package com.universe.al.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N阶台阶，每次1或2阶，有多少走法
 *
 * @author l
 */
public class ClimbStairs {

    /**
     * 回溯
     */
    public static int solution(int n) {
        List<Integer> choices = Arrays.asList(1, 2);
        int state = 0;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        backTrack(state, choices, n, res);
        return res.get(0);
    }

    public static void backTrack(int state, List<Integer> choices, int n, List<Integer> res) {
        if (state == n) {
            res.set(0, res.get(0) + 1);
            return;
        }
        for (Integer choice : choices) {
            if (state + choice > n) {
                continue;
            }
            backTrack(state + choice, choices, n, res);
        }
    }

    /**
     * 第n阶 只能从 n-1 或 n-2 阶到达，费内巴切公式
     */
    public static int solution1(int n) {
        return dfs(n);
    }

    public static int dfs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return dfs(n - 1) + dfs(n - 2);
    }

    public static int solutionMem(int n) {
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return dfsMem(n, mem);
    }

    public static int dfsMem(int n, int[] mem) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        int memCount = dfsMem(n - 1, mem) + dfsMem(n - 2, mem);
        mem[n] = memCount;
        return memCount;
    }

    /**
     * 【动态规划】
     * 将数组 dp 称为【dp 表】，【dp[i]】表示状态【i】对应子问题的解。
     * 将最小子问题对应的状态（第【1】阶和第【2】阶楼梯）称为「初始状态」。
     * 将递推公式 【dp[i] = dp[i-1] + dp[i-2]】称为「状态转移方程」。
     */
    public static int solutionDynamic(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 【滚动变量】or【滚动数组】
     * 空间优化，只能返回最终N阶时的结果，不保存中间过程。
     * @param n
     * @return
     */
    public static int solutionSpace(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution1(4));
        System.out.println(solutionMem(4));
        System.out.println(solutionDynamic(4));
        System.out.println(solutionSpace(4));
    }

}
