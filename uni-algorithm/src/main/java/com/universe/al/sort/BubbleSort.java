package com.universe.al.sort;

import java.util.Arrays;

/**
 * gudu
 *
 * @author l
 */
public class BubbleSort {

    /**
     * old
     *
     * @param nums
     */
    public static void solution(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 0; j <nums.length - 1; j++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void solution1(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }


    public static void solution2(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            /** 每轮内循环结束后，外循环置位false */
            boolean flag = false;
            /** 内循环 进行交换，有交换动作为true*/
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            /** 说明内循环里不发生交换了 */
            if (!flag) {
                break;
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 8, 5, 3, 2, 6};
//        solution(nums);
//        solution1(nums);
        solution2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
