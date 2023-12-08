package com.universe.al.sort;

import java.util.Arrays;

/**
 * @author l
 */
public class QuickSort {

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        /**左<右*/
        while (i < j) {
            /**都跟基准比较，小的去左，大的去右*/
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        /**将基准放在左右分组中间*/
        swap(nums, i, left);
        return i;
    }

    /**
     * 基础
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void solution(int[] nums, int left, int right) {
        if (left < right) {
            /** 分组*/
            int partition = partition(nums, left, right);
            /**左右递归*/
            solution(nums, left, partition - 1);
            solution(nums, partition + 1, right);
        }
    }

    public static int mid(int[] nums, int left, int mid, int right) {
        if ((nums[left] < nums[mid]) ^ (nums[left] < nums[right])) {
            return left;
        } else if ((nums[mid] < nums[right]) ^ (nums[mid] < nums[right])) {
            return mid;
        } else {
            return right;
        }
    }

    public static int partition1(int[] nums, int left, int right) {
        int p = mid(nums, left, (left + right)/2, right);
        swap(nums, left, p);
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[i] < nums[left]) {
                i++;
            }
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }

            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    /**
     * 基准值优化
     *
     * @param nums
     * @param left
     * @param right
     */
    public static void solution1(int[] nums, int left, int right) {
        if (left < right) {
            int i = partition1(nums, left, right);
            solution1(nums, left, i - 1);
            solution1(nums, i + 1, right);
        }
    }

    public static void solution2(int[] nums, int left, int right) {
        while (left < right) {
            int i = partition1(nums, left, right);
            if ((i - left) < (right - i)) {
                solution2(nums,left,i-1);
                left = i+1;
            }else {
                solution2(nums,i+1,right);
                right = i-1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        solution(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        solution1(nums1, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        solution2(nums2, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums2));
    }

}
