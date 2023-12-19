package com.universe.al.dynamic;

/**
 * @author l
 */
public class Knapsack {

    /**
     * 给定 n 个物品，第 i 个物品的重量为 wgt[i-1]、价值为 val[i-1]，和一个容量为 cap 的背包。
     * 每个物品只能选择一次，问在限定背包容量下能放入物品的最大价值。
     */
    public static int solutionRude(int[] wgt, int[] val, int i, int cap) {
        if (i == 0 || cap == 0) {
            return 0;
        }
        if (wgt[i - 1] > cap) {
            return solutionRude(wgt, val, i - 1, cap);
        }
        int no = solutionRude(wgt, val, i - 1, cap);
        int yes = solutionRude(wgt, val, i - 1, cap - wgt[i - 1]) + val[i - 1];
        return Math.max(no, yes);
    }

    public static void main(String[] args) {
        int[] wgt = {10, 20, 30, 40, 50};
        int[] val = {50, 120, 150, 210, 240};
        int cap = 50;
        int n = wgt.length;

        System.out.println(solutionRude(wgt, val, n, cap));
    }
}
