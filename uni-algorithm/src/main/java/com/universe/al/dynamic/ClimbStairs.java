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


    /**
     * 【最优子结构】
     * 给定一个楼梯，你每步可以上 1 阶或者 2 阶，每一阶楼梯上都贴有一个非负整数，表示你在该台阶所需要付出的代价。
     * 给定一个非负整数数组cost，其中cost[i]表示在第 i 个台阶需要付出的代价，cost[0]为地面（起始点）。
     * 请计算最少需要付出多少代价才能到达顶部？
     * @return
     */
    public static int solutionSun(int[] cost) {
        int n = cost.length - 1;
        if (n == 1 || n == 2) {
            return cost[n];
        }

        int[] dp = new int[n+1];
        dp[1] = cost[1];
        dp[2] = cost[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return dp[n];
    }

    public static int solutionSunSpace(int[] cost) {
        int n = cost.length - 1;
        if (n == 1 || n == 2) {
            return cost[n];
        }

        int a = cost[1], b = cost[2];
        for (int i = 3; i <= n; i++) {
            int tmp = b;
            b = Math.min(a,tmp) + cost[i];
            a = tmp;
        }
        return b;
    }

    /**
     * 不满足【无后效性：给定一个确定的状态，它的未来发展只与当前状态有关，而与过去经历的所有状态无关。】
     * 给定一个共有 n 阶的楼梯，每步可以上 1 阶或者 2 阶，但不能连续两轮跳 1 阶，返回爬到楼顶的方案数量
     * @param n
     * @return
     */
    public static int solutionConstraint(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        /**dp[i][j] 在第i层，采用了j（1 或 2）方式 的方案数
         * [i,1] 不能连续跳1阶，[i-1,2]
         * [i,2] 不能连续跳1阶，[i-1,1] + [i-2,2]
         * */
        int[][] dp = new int[n+1][3];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[2][1] = 0;
        dp[2][2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][1] = dp[i-1][2];
            dp[i][2] = dp[i-1][1] + dp[i-2][2];
        }
        return dp[n][1] + dp[n][2];
    }


    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution1(4));
        System.out.println(solutionMem(4));
        System.out.println(solutionDynamic(4));
        System.out.println(solutionSpace(4));

        int[] cost = { 0, 1, 10, 1, 1, 1, 10, 1, 1, 10, 1 };
        System.out.println(String.format("输入楼梯的代价列表为 %s", Arrays.toString(cost)));

        int res = solutionSun(cost);
        System.out.printf("爬完楼梯的最低代价为 %d%n", res);

        int res1 = solutionSunSpace(cost);
        System.out.printf("爬完楼梯的最低代价为 %d%n", res1);

        System.out.println(solutionConstraint(4));
    }

}
