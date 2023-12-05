package com.universe.al.sort;

import java.util.Arrays;

/**
 * 选择
 *
 * @author hongqi
 */
public class SelectionSort {

    public static void solution(int[] nums) {

        /** 开启循环 */
        for (int i = 0; i < nums.length-1; i++) {

            /** **循环找比【i】小的  */
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

}
