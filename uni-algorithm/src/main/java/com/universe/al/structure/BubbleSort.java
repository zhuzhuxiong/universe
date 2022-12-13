package com.universe.al.structure;

import java.util.Arrays;

/**
 * 0913-咕嘟
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,2,4};
//        int[] ints = commonSolution(nums);
        flagSolution(nums);

        Arrays.sort(nums);
        int[] ints = Arrays.copyOf(nums, 3);

        System.out.println(ints[0]);
        System.out.println(ints[1]);
        System.out.println(ints[2]);
        System.out.println(nums[3]);
        System.out.println(nums[4]);
        System.out.println(nums[5]);
    }

    public static int[] commonSolution(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            //没过一轮 少拍一个数
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] flagSolution(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return nums;
    }

    public static int[] comSolutionTest(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] flagSolutionTest(int[] nums) {



        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return nums;
    }
}
