package com.universe.al.array;

/**
 * @author
 */
public class LeeCode28 {

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "";
        int solution = new LeeCode28().solution(haystack, needle);
        System.out.println(solution);
    }

    /**
     *
     * @param
     * @return
     */
    public int solution(String haystack, String needle){
        if ("".equals(haystack) && "".equals(needle)) {
            return 0;
        }else if ("".equals(needle)){
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                return i;
            }
        }
        return -1;

    }
}
