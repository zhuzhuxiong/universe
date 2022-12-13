package com.universe.al.number;


public class reviseNum {

    public static int solution(int x){
        int res = 0;
        while (x != 0){
            int t = x % 10;
            int newRes = res * 10 + t;
            if (newRes - t != res * 10){
                return 0;
            }
            x = x / 10;
            res = newRes;
        }
        return res;
    }

    public static int solution2(int x){
        long res = 0;
        while (x != 0){
            res = x % 10 + res * 10;
            x = x /10;
        }
        return (int) res ==  res ? (int) res : 0;
    }

    public static void main(String[] args) {

    }


}
