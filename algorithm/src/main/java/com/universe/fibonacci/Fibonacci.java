package com.universe.fibonacci;

/**
 *
 * 费内巴切
 * 青蛙跳台阶
 */
public class Fibonacci {

    public static void main(String[] args) {
        int fib = fib2(3);
        System.out.println(fib);
    }

    //动态规划
    //设正整数 x, y, px,y,p ，求余符号为 \odot⊙ ，则有 (x + y) \odot p = (x \odot p + y \odot p) \odot p(x+y)⊙p=(x⊙p+y⊙p)⊙p 。
    public static int fib(int n){
        int a = 0,b = 1,num;
        for (int i = 0; i < n; i++) {
            num = (a + b)%1000000007;
            a = b;
            b = num;
        }
        return a;

    }

    //基础问题，递归版
    public static int fib2(int n){
        if (n == 0 || n==1){
            return n;
        }else {
            return fib2(n-1) + fib2(n-2);
        }
    }
}
