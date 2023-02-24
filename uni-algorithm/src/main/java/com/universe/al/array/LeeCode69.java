package com.universe.al.array;

/**
 * X 的平方根
 * @author l
 */
public class LeeCode69 {

    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        int low = 0,high = x,ans = -1;
        while (low <= high) {
            //(high + low) /2
           int mid = low + (high - low)/2;
           if ((long) mid * mid <= x) {
               ans = mid;
               low = mid + 1;
           }else {
               high = mid - 1;
           }
        }
        return ans;
    }

}
