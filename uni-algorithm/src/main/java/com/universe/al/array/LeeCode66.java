package com.universe.al.array;

/**
 * 加一
 * @author l
 */
public class LeeCode66 {

    public static void main(String[] args) {

    }

    /**
     * {9,9} -> {1,0,0}
     * 分析，
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        for (int i = digits.length -1; i >=0 ; --i) {
            //加一后，判断是不是0，不是0，加一返回 结束
            digits[i] = (digits[i] + 1) % 10;
            if (0 != digits[i]) {
                return digits;
            }
        }
        //{9,9} -> {1,0,0}
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
