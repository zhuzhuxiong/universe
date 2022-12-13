package com.universe.al.array;

public class FindFirstOnly {

    public static void main(String[] args) {
        String s = "loveleetcode";
        int solution = solution(s);
        System.out.println("solution----:" + solution);
    }

    public static int solution(String s){

        int[] ints = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            ints[chars[i] - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ints[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return  -1;
    }
}
