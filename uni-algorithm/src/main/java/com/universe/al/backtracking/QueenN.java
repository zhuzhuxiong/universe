package com.universe.al.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 */
public class QueenN {

    /***
     * 在N*N 的棋盘内，有N个皇后，使得每个皇后所在的行、列、主、次对角线无其他棋子，返回符合条件的排列方式。
     * @param n
     * @return
     */
    public static List<List<List<String>>> solution(int n) {
        /** 初始化N*N的棋盘，将所有位置放入“#”，后续皇后位置放“Q” */
        List<List<String>> state = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("#");
            }
            state.add(row);
        }
        /** 记录列是否有皇后 */
        boolean[] cols = new boolean[n];
        /** 记录主对角线、次对角线是否有皇后 */
        boolean[] diags1 = new boolean[2 * n - 1];
        boolean[] diags2 = new boolean[2 * n - 1];
        List<List<List<String>>> res = new ArrayList<>();
        /** row：第row行 */
        backTrack(0, n, state, res, cols, diags1, diags2);
        return res;
    }

    private static void backTrack(int row, int n, List<List<String>> state, List<List<List<String>>> res
            , boolean[] cols, boolean[] diags1, boolean[] diags2) {
        /** 第row行 = n 即所有行都放置完成 */
        if (row == n) {
            /** new list 暂存结果 */
            List<List<String>> copyState = new ArrayList<>();
            for (List<String> cRow : state) {
                copyState.add(new ArrayList<>(cRow));
            }
            res.add(copyState);
            return;
        }

        /** 遍历列，行的遍历通过递归 */
        for (int col = 0; col < n; col++) {
            /** 主、副对角线 */
            int diag1 = row - col + n - 1;
            int diag2 = row + col;

            /** 剪枝 列，对角线 都不存在 */
            if (!cols[col] && !diags1[diag1] && !diags2[diag2]) {
                state.get(row).set(col, "Q");
                cols[col] = diags1[diag1] = diags2[diag2] = true;
                backTrack(row + 1, n, state, res, cols, diags1, diags2);
                state.get(row).set(col, "#");
                cols[col] = diags1[diag1] = diags2[diag2] = false;
            }
        }

    }

    public static void main(String[] args) {

        List<List<List<String>>> list = solution(4);

        for (List<List<String>> state : list) {
            System.out.println("--------------------");
            for (List<String> row : state) {
                System.out.println(row);
            }
        }
    }
}
