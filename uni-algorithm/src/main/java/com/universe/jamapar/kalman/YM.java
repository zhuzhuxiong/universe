package com.universe.jamapar.kalman;



import Jama.Matrix;

import java.util.Vector;

/**
 * Y-W方程求解
 */
public class YM {
    /**
     * @param garma 代表的是数据的协方差
     * @return 返回经由Y-W方程求解的结果，其中数组的最后
     * 一个元素存储的是模型中的噪声方差
     */
    public double[] YWSolve(double[] garma) {
        int order = garma.length - 1;
        double[] garmaPart = new double[order];
        System.arraycopy(garma, 1, garmaPart, 0, order);

        // 将协方差转换为矩阵的形式
        double[][] garmaArray = new double[order][order];
        for (int i = 0; i < order; ++i) {
            // 对角线
            garmaArray[i][i] = garma[0];

            //下三角
            int subIndex = i;
            for (int j = 0; j < i; ++j) {
                garmaArray[i][j] = garma[subIndex--];
            }

            //上三角
            int topIndex = i;
            for (int j = i + 1; j < order; ++j) {
                garmaArray[i][j] = garma[++topIndex];
            }
        }

        /* 调用了jma包，其实现了大部分对矩阵的操作 */
        /* 可能会存在矩阵不可逆的情况，在矩阵不可逆时
        可以通过将对角线元素全部增加1e-6做修正 */
        Matrix garmaMatrix = new Matrix(garmaArray);
        Matrix garmaMatrixInverse = garmaMatrix.inverse();
        Matrix autoReg = garmaMatrixInverse.times(new Matrix(garmaPart, order));

        double[] result = new double[autoReg.getRowDimension() + 1];
        for (int i = 0; i < autoReg.getRowDimension(); ++i) {
            result[i] = autoReg.get(i, 0);
        }

        double sum = 0.0;
        for (int i = 0; i < order; ++i) {
            sum += result[i] * garma[i];
        }
        result[result.length - 1] = garma[0] - sum;
        return result;
    }


    /**
     * Levinson 递推公式求解
     *
     * @param garma 代表的是数据的协方差
     * @return 返回结果的第一行元素代表的是在迭代过程中的方差，
     * 其余的元素代表的是迭代过程中存储的系数
     */
    public double[][] LevinsonSolve(double[] garma) {
        int order = garma.length - 1;
        double[][] result = new double[order + 1][order + 1];
        double[] sigmaSq = new double[order + 1];

        sigmaSq[0] = garma[0];
        result[1][1] = garma[1] / sigmaSq[0];
        sigmaSq[1] = sigmaSq[0] * (1.0 - result[1][1] * result[1][1]);
        for (int k = 1; k < order; ++k) {
            double sumTop = 0.0;
            double sumSub = 0.0;
            for (int j = 1; j <= k; ++j) {
                sumTop += garma[k + 1 - j] * result[k][j];
                sumSub += garma[j] * result[k][j];
            }
            result[k + 1][k + 1] = (garma[k + 1] - sumTop) / (garma[0] - sumSub);
            for (int j = 1; j <= k; ++j) {
                result[k + 1][j] = result[k][j] - result[k + 1][k + 1] * result[k][k + 1 - j];
            }
            sigmaSq[k + 1] = sigmaSq[k] * (1.0 - result[k + 1][k + 1] * result[k + 1][k + 1]);
        }
        result[0] = sigmaSq;

        return result;
    }

    /**
     * 3). AR(p) 参数估计
     *
     * @param originalData 原始数据
     * @param p            模型的阶数
     * @return AR模型的系数
     */
    public double[] computeARCoe(double[] originalData, int p) {
        double[] garma = new JisuanFunction().autoCovData(originalData, p);        //p+1

        double[][] result = this.LevinsonSolve(garma);     //(p + 1) * (p + 1)
        double[] ARCoe = new double[p + 1];
        for (int i = 0; i < p; ++i) {
            ARCoe[i] = result[p][i + 1];
        }
        ARCoe[p] = result[0][p];        //噪声参数

//       return this.YWSolve(garma);
        return ARCoe;
    }

    /**
     * MA(q) 参数估计
     * 在求解MA系数的过程中，需要先求解AR(pn)模型。通过确定的pn阶数来求取MA(q)模型的偏相关函数，
     * 从而求得MA(q)的系数。当然此处的AR(pn)的阶数也可自己给定，比如K*log(N),K为一整数，
     * N为数据长度，具体可参见前一链接。
     *
     * @param originalData 原始数据
     * @param q            模型阶数
     * @return MA系数
     */
    public double[] computeMACoe(double[] originalData, int q) {
        // 确定最佳的p
        int p = 0;
        double minAIC = Double.MAX_VALUE;
        int len = originalData.length;
        if (len > 10) {
            len = 10;
        }
        for (int i = 1; i < len; ++i) {
            double[] garma = new JisuanFunction().autoCovData(originalData, i);
            double[][] result = this.LevinsonSolve(garma);

            double[] ARCoe = new double[i + 1];
            for (int k = 0; k < i; ++k) {
                ARCoe[k] = result[i][k + 1];
            }
            ARCoe[i] = result[0][i];
//          double [] ARCoe = this.YWSolve(garma);

            Vector<double[]> vec = new Vector<>();
            vec.add(ARCoe);
            double aic = new ARMAMethod().getModelAIC(vec, originalData, 2);
            if (aic < minAIC) {
                minAIC = aic;
                p = i;
            }
        }

//      System.out.println("The best p is " + p);
        // 求取系数
        double[] bestGarma = new JisuanFunction().autoCovData(originalData, p);
        double[][] bestResult = this.LevinsonSolve(bestGarma);

        double[] alpha = new double[p + 1];
        alpha[0] = -1;
        for (int i = 1; i <= p; ++i) {
            alpha[i] = bestResult[p][i];
        }

//      double [] result = this.YWSolve(bestGarma);
//      double [] alpha = new double[p + 1];
//      alpha[0] = -1;
//      for (int i = 1; i <= p; ++i)
//      {
//          alpha[i] = result[i - 1];
//      }
        double[] paraGarma = new double[q + 1];
        for (int k = 0; k <= q; ++k) {
            double sum = 0.0;
            for (int j = 0; j <= p - k; ++j) {
                sum += alpha[j] * alpha[k + j];
            }
            paraGarma[k] = sum / bestResult[0][p];
        }

        double[][] tmp = this.LevinsonSolve(paraGarma);
        double[] MACoe = new double[q + 1];
        for (int i = 1; i < MACoe.length; ++i) {
            MACoe[i] = tmp[q][i];
        }
        MACoe[0] = tmp[0][q];       //噪声参数

//      double [] tmp = this.YWSolve(paraGarma);
//      double [] MACoe = new double[q + 1];
//      System.arraycopy(tmp, 0, MACoe, 1, tmp.length - 1);
//      MACoe[0] = tmp[tmp.length - 1];

        return MACoe;
    }

    /**
     * ARMA(p, q) 参数估计
     *
     * @param originalData 原始数据
     * @param p            AR模型阶数
     * @param q            MA模型阶数
     * @return ARMA模型系数
     */
    public double[] computeARMACoe(double[] originalData, int p, int q) {
        double[] allGarma = new JisuanFunction().autoCovData(originalData, p + q);
        double[] garma = new double[p + 1];
        for (int i = 0; i < garma.length; ++i) {
            garma[i] = allGarma[q + i];
        }
        double[][] arResult = this.LevinsonSolve(garma);

        // AR
        double[] ARCoe = new double[p + 1];
        for (int i = 0; i < p; ++i) {
            ARCoe[i] = arResult[p][i + 1];
        }
        ARCoe[p] = arResult[0][p];
//      double [] ARCoe = this.YWSolve(garma);

        // MA
        double[] alpha = new double[p + 1];
        alpha[0] = -1;
        for (int i = 1; i <= p; ++i) {
            alpha[i] = ARCoe[i - 1];
        }

        double[] paraGarma = new double[q + 1];
        for (int k = 0; k <= q; ++k) {
            double sum = 0.0;
            for (int i = 0; i <= p; ++i) {
                for (int j = 0; j <= p; ++j) {
                    sum += alpha[i] * alpha[j] * allGarma[Math.abs(k + i - j)];
                }
            }
            paraGarma[k] = sum;
        }
        double[][] maResult = this.LevinsonSolve(paraGarma);
        double[] MACoe = new double[q + 1];
        for (int i = 1; i <= q; ++i) {
            MACoe[i] = maResult[q][i];
        }
        MACoe[0] = maResult[0][q];

//      double [] tmp = this.YWSolve(paraGarma);
//      double [] MACoe = new double[q + 1];
//      System.arraycopy(tmp, 0, MACoe, 1, tmp.length - 1);
//      MACoe[0] = tmp[tmp.length - 1];

        double[] ARMACoe = new double[p + q + 2];
        for (int i = 0; i < ARMACoe.length; ++i) {
            if (i < ARCoe.length) {
                ARMACoe[i] = ARCoe[i];
            } else {
                ARMACoe[i] = MACoe[i - ARCoe.length];
            }
        }
        return ARMACoe;
    }

}
