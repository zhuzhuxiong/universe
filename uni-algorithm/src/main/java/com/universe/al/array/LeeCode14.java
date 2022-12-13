package com.universe.al.array;

/**
 * @author
 */
public class LeeCode14 {

    public static void main(String[] args) {
        String[] strs = {"aaa","aa","aaa"};
        String solution = new LeeCode14().solution(strs);
        System.out.println(solution);
    }

    /**
     * 横向对比
     * @param strs 输入
     * @return L
     *
     */
    public String solution(String[] strs) {
        if (null == strs || strs.length == 0){
            return "";
        }
        String fir = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int min = Math.min(fir.length(), str.length());
            int index = 0;
            while (index < min && fir.charAt(index) == str.charAt(index)){
                index++;
            }
            fir  = fir.substring(0,index);
            if (fir.length() == 0){
                break;
            }

        }
        return fir;
    }

    /**
     * 纵向对比
     * @return L
     */
    public String solution2(String[] strs) {
        if (null == strs || 0 == strs.length){
            return "";
        }
        int strsLength = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strsLength; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }

            }
        }
        return strs[0];
    }
}
