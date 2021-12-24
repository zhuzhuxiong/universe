package com.universe.jamapar.kalman;

import java.util.Random;
import java.util.Vector;

/**
 *
 */
public class ARMAMethod {

    /**
     * @param vec       模型的系数
     * @param data      数据
     * @param type      选定的模型
     * @return
     */
    public double getModelAIC(Vector<double []> vec, double [] data, int type)
    {
        int n = data.length;
        int p = 0, q = 0;
        double tmpAR = 0.0, tmpMA = 0.0;
        double sumErr = 0.0;
        Random random = new Random();

        /* MA */
        if (type == 1)
        {
            double [] maCoe = vec.get(0);
            q = maCoe.length;
            double [] errData = new double[q];

            for (int i = q - 1; i < n; ++i)
            {
                tmpMA = 0.0;
                for (int j = 1; j < q; ++j)
                {
                    tmpMA += maCoe[j] * errData[j];
                }

                for (int j = q - 1; j > 0; --j)
                {
                    errData[j] = errData[j - 1];
                }
                errData[0] = random.nextGaussian() * Math.sqrt(maCoe[0]);
                sumErr += (data[i] - tmpMA) * (data[i] - tmpMA);
            }
//          return Math.log(sumErr) + (q + 1) * 2 / n;
            return (n - (q - 1)) * Math.log(sumErr / (n - (q - 1))) + (q + 1) * 2;
            // return  (n-(q-1))*Math.log(sumErr/(n-(q-1)))+(q)*Math.log(n-(q-1));      //AIC 最小二乘估计
        }
        /* AR */
        else if (type == 2)
        {
            double [] arCoe = vec.get(0);
            p = arCoe.length;

            for (int i = p - 1; i < n; ++i)
            {
                tmpAR = 0.0;
                for (int j = 0; j < p - 1; ++j)
                {
                    tmpAR += arCoe[j] * data[i - j - 1];
                }
                sumErr += (data[i] - tmpAR) * (data[i] - tmpAR);
            }
//          return Math.log(sumErr) + (p + 1) * 2 / n;
            return (n - (p - 1)) * Math.log(sumErr / (n - (p - 1))) + (p + 1) * 2;
            // return (n-(p-1))*Math.log(sumErr/(n-(p-1)))+(p)*Math.log(n-(p-1));       //AIC 最小二乘估计
        }
        /* ARMA */
        else
        {
            double [] arCoe = vec.get(0);
            double [] maCoe = vec.get(1);
            p = arCoe.length;
            q = maCoe.length;
            double [] errData = new double[q];

            for (int i = p - 1; i < n; ++i)
            {
                tmpAR = 0.0;
                for (int j = 0; j < p - 1; ++j)
                {
                    tmpAR += arCoe[j] * data[i - j - 1];
                }
                tmpMA = 0.0;
                for (int j = 1; j < q; ++j)
                {
                    tmpMA += maCoe[j] * errData[j];
                }

                for (int j = q - 1; j > 0; --j)
                {
                    errData[j] = errData[j - 1];
                }
                errData[0] = random.nextGaussian() * Math.sqrt(maCoe[0]);

                sumErr += (data[i] - tmpAR - tmpMA) * (data[i] - tmpAR - tmpMA);
            }
//          return Math.log(sumErr) + (q + p + 1) * 2 / n;
            return (n - (q + p - 1)) * Math.log(sumErr / (n - (q + p - 1))) + (p + q) * 2;
            // return (n-(p-1))*Math.log(sumErr/(n-(p-1)))+(p+q-1)*Math.log(n-(p-1));       //AIC 最小二乘估计
        }
    }
}
