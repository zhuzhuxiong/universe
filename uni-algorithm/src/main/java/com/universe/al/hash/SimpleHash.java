package com.universe.al.hash;

import java.util.HashMap;

/**
 * 简单hash算法
 *
 * @author l
 */
public class SimpleHash {

    public static void main(String[] args) {
        String str = "hello,hash";
        System.out.println(addHash(str));
        System.out.println(mulHash(str));
        System.out.println(xorHash(str));
        System.out.println(revolveHash(str));
    }

    public static int addHash(String key) {
        long hash = 0;
        /** 大质数作为取余的系数 */
        final int modulus = 1000000007;
        for (char c : key.toCharArray()) {
            hash = (hash + (int) c) % modulus;
        }
        return (int) hash;
    }

    public static int mulHash(String key) {
        long hash = 0;
        /** 大质数作为取余的系数 */
        final int modulus = 1000000007;
        for (char c : key.toCharArray()) {
            /** 加法的基础上 每轮结果乘以系数 */
            hash = (hash * 31 + (int) c) % modulus;
        }
        return (int) hash;
    }

    public static int xorHash(String key) {
        long hash = 0;
        /** 大质数作为取余的系数 */
        final int modulus = 1000000007;
        for (char c : key.toCharArray()) {
            hash = hash ^ (int) c;
        }
        return (int) hash;
    }

    public static int revolveHash(String key) {
        long hash = 0;
        /** 大质数作为取余的系数 */
        final int modulus = 1000000007;
        for (char c : key.toCharArray()) {
            hash = ((hash << 4) ^ (hash >> 28) ^ (int)c) % modulus;
        }
        return (int) hash;
    }
}
