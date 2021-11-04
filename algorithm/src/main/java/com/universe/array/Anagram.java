package com.universe.array;

import java.util.Arrays;

/**
 * 异位词
 */
public class Anagram {

    public static void main(String[] args) {

    }

    /**
     * 一增一减 异位词则结果都是0；
     *
     * @param s1 数组1
     * @param s2 数组2
     * @return boolean
     */
    public boolean solution(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * string 同 数组
     * 排序
     * 逐位对比
     *
     * @param s
     * @param t
     * @return
     */
    public boolean solution2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }

    /**
     * 在同一个循环中 对 数组的元素进行增减 ==0 则是异位词
     * @param s
     * @param t
     * @return
     */
    public boolean solution3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (++map[chars[i] - 'a'] == 1) {
                count++;
            }
            if (--map[chart[i] - 'a'] == 0) {
                count--;
            }
        }
        return count == 0;
    }


}
