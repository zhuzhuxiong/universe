package com.universe.kalman;

public class JisuanFunction {

    /**
     * @param originalData
     * @return 均值
     */
    public double avgData(double[] originalData) {
        return this.sumData(originalData) / originalData.length;
    }

    /**
     * @param originalData
     * @return 求和
     */
    public double sumData(double[] originalData) {
        double sum = 0.0;

        for (int i = 0; i < originalData.length; ++i) {
            sum += originalData[i];
        }
        return sum;
    }

    /**
     * 计算标准差 sigma = sqrt(var);
     *
     * @param originalData
     * @return 标准差
     */
    public double stdErrData(double[] originalData) {
        return Math.sqrt(this.varErrData(originalData));
    }

    /**
     * 计算方差 var = sum(x - mu) ^2 / N;
     *
     * @param originalData
     * @return 方差
     */
    public double varErrData(double[] originalData) {
        if (originalData.length <= 1) {
            return 0.0;
        }
        double var = 0.0;
        double mu = this.avgData(originalData);

        for (int i = 0; i < originalData.length; ++i) {
            var += (originalData[i] - mu) * (originalData[i] - mu);
        }
        var /= (originalData.length - 1);       //方差的无偏估计

        return var;
    }

    /**
     * @param dataFir
     * @param dataSec
     * @return 皮尔逊相关系数(互相关)
     */
    public double mutalCorr(double[] dataFir, double[] dataSec) {
        double sumX = 0.0;
        double sumY = 0.0;
        double sumXY = 0.0;
        double sumXSq = 0.0;
        double sumYSq = 0.0;
        int len = 0;

        if (dataFir.length != dataSec.length) {
            len = Math.min(dataFir.length, dataSec.length);
        } else {
            len = dataFir.length;
        }
        for (int i = 0; i < len; ++i) {
            sumX += dataFir[i];
            sumY += dataSec[i];
            sumXY += dataFir[i] * dataSec[i];
            sumXSq += dataFir[i] * dataFir[i];
            sumYSq += dataSec[i] * dataSec[i];
        }

        double numerator = sumXY - sumX * sumY / len;
        double denominator = Math.sqrt((sumXSq - sumX * sumX / len) * (sumYSq - sumY * sumY / len));

        if (denominator == 0) {
            return 0.0;
        }

        return numerator / denominator;
    }

    /**
     * @param data
     * @return 互相关矩阵
     */
    public double[][] computeMutalCorrMatrix(double[][] data) {
        double[][] result = new double[data.length][data.length];
        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data.length; ++j) {
                result[i][j] = this.mutalCorr(data[i], data[j]);
            }
        }

        return result;
    }

    /**
     * 计算自协方差，C(k)=sum((x(t)-mu)*(x(t-k)-mu))/(N-k);
     *
     * @param originalData
     * @param order
     * @return 自协方差(gama ( k))-->认为是自相关系数
     */
    public double[] autoCovData(double[] originalData, int order) {
        double mu = this.avgData(originalData);
        double[] autoCov = new double[order + 1];

        for (int i = 0; i <= order; ++i) {
            autoCov[i] = 0.0;
            for (int j = 0; j < originalData.length - i; ++j) {
                autoCov[i] += (originalData[i + j] - mu) * (originalData[j] - mu);
            }
            autoCov[i] /= (originalData.length - 1);
        }
        return autoCov;
    }

    /**
     * 计算自相关函数(系数) rou(k) = C(k) / C(0);
     * 其中 C(k) = sum((x(t) - mu)*(x(t - k) - mu)) / (N - k),
     * C(0) = var =  sum(x(t) - mu) ^2 / N;
     *
     * @param originalData
     * @param order
     * @return 自相关函数(rou ( k))
     */
    public double[] autoCorrData(double[] originalData, int order) {
        double[] autoCov = this.autoCovData(originalData, order);
        double[] autoCorr = new double[order + 1];     //默认初始化为0
        double var = this.varErrData(originalData);

        if (var != 0) {
            for (int i = 0; i < autoCorr.length; ++i) {
                autoCorr[i] = autoCov[i] / var;
            }
        }

        return autoCorr;
    }
}
