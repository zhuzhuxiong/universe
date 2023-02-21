package com.universe.al.array;

import java.util.HashMap;

/**
 * 罗马数字转int
 *
 * @author L
 */
public class LeeCode13 {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int length = s.length();
        int num = 0;
        //找规律，左减右加
        for (int i = 0; i < length; i++) {
            Integer pre = map.get(s.charAt(i));
            if (i < length -1 && pre < map.get(s.charAt(i + 1))){
                num = num - pre;
            }else {
                num = num + pre;
            }
        }
        return num;
    }
}
