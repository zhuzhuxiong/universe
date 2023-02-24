package com.universe.al.fibonacci;


/**
 * 费内巴切
 * 爬楼梯 LeeCode70
 *  @author l
 *  @date 2023/2/22 14:04
*/
public class Fibonacci {


    public static void main(String[] args) {
    }

    /**
     * 递归方式 会超时
     * @author l
     * @date  2023/2/22 14:11
     * @param n
     * @return int
     **/
    public int climbStairs(int n) {
        if (n == 0 || n ==1) {
            return n;
        }else {
           return climbStairs(n-1) + climbStairs(n-2);
        }
    }

    /**
     * 动态规划 答案
     * 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
     *
     * 爬上 n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
     * 爬上 n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
     * f(n) = f(n-1) + f(n-2)
     * @author l
     * @date  2023/2/22 14:12
     * @param n
     * @return int
     **/
    public static int fib(int n){
        int p,q = 0,r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p+ q;
        }
        return r;
    }

}
