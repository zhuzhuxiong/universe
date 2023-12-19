package com.universe.al.greedy;

/**
 * @author l
 */
public class CoinChange {

    /**
     * 给定 n 种硬币，第 i 种硬币的面值为 coins[i] ，目标金额为 amt ，每种硬币可以重复选取，
     * 问能够凑出目标金额的最少硬币数量。如果无法凑出目标金额则返回
     */
    public static int solution(int[] coins, int amt) {
        int length = coins.length - 1;
        int count = 0;
        while (amt > 0) {
            while (length > 0 && coins[length] > amt) {
                length--;
            }
            amt = amt - coins[length];
            count++;
        }
        return amt == 0 ? count : -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 20, 50, 100};
        System.out.println(solution(coins, 131));
    }
}
