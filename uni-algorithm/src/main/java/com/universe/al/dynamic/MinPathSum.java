package com.universe.al.dynamic;

import java.util.Arrays;

/**
 * @author l
 */
public class MinPathSum {

    /**
     * 给定一个 m*n 的二维网格 grid，网格中的每个单元格包含一个非负整数，表示该单元格的代价。
     * 以左上角单元格为起始点，每次只能向下或者向右移动一步，直至到达右下角单元格。
     * 请返回从左上角到右下角的最小路径和。
     * {{ 1, 3, 1, 5 },
     * { 2, 2, 4, 2 },
     * { 5, 3, 2, 1 },
     * { 4, 3, 5, 2 }};
     */
    public static int rudeSearch(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (j < 0 || i < 0) {
            return Integer.MAX_VALUE;
        }
        int up = rudeSearch(grid, i - 1, j);
        int left = rudeSearch(grid, i, j - 1);
        return Math.min(left, up) + grid[i][j];
    }

    /***
     * 【记忆化搜索】
     */
    public static int solutionMem(int[][] grid, int[][] mem, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int up = solutionMem(grid, mem, i - 1, j);
        int left = solutionMem(grid, mem, i, j - 1);
        mem[i][j] = Math.min(up, left) + grid[i][j];
        return mem[i][j];
    }

    public static int solutionDP(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1, 5},
                {2, 2, 4, 2},
                {5, 3, 2, 1},
                {4, 3, 5, 2}
        };
        int i = grid.length;
        int j = grid[0].length;

        System.out.println(rudeSearch(grid, i-1, j-1));

        int[][] mem = new int[i][j];
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        System.out.println(solutionMem(grid, mem, i-1, j-1));

        System.out.println(solutionDP(grid));
    }
}
