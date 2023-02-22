package com.universe.al.array;

/**
 * 最后一个单词长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。
 * 返回字符串中 最后一个 单词的长度
 * @author l
 */
public class LeeCode58 {

    public static void main(String[] args) {

    }

    /**
     * 偷只因 偷麻了
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    /**
     * 反向遍历 ：String - char
     * @param s
     * @return
     */
    public int lengthOfLastWord1(String s) {
        int length = s.length() - 1;
        while (s.charAt(length) == ' '){
            length--;
        }
        int wLength = 0;
        while (length >= 0 && s.charAt(length) != ' '){
            length --;
            wLength++;
        }
        return wLength;
    }

}
