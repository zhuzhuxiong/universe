package com.universe.al.sort;

import java.util.Arrays;

/**
 * @author l
 */
public class HeapSort {

    public static void solution(int[] nums) {

        /**nums 堆化 初始化操作 */
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }

        /** swap与堆顶元素交换位置；保持堆化 */
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            siftDown(nums, i, 0);
        }
    }

    public static void siftDown(int[] nums, int n, int i) {
        while (true) {
            /** 左右子节点位置 */
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            /** 堆顶 */
            int max = i;
            /** n 未排序长度，找对比子节点，找最大*/
            if (l < n && nums[l] > nums[max]) {
                max = l;
            }
            if (r < n && nums[r] > nums[max]) {
                max = r;
            }
            /** 终止条件 */
            if (max == i) {
                break;
            }
            /** 根 与 子节点交换位置*/
            swap(nums, i, max);
            /** 向下循环 */
            i = max;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        solution(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        practice(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void practice(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            sift(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            sift(nums, i, 0);
        }
    }

    public static void sift(int[] nums, int n, int i) {
        while (true) {
            int r = 2 * i + 2;
            int l = 2 * i + 1;
            int mix = i;
            if (l < n && nums[l] > nums[mix]) {
                mix = l;
            }
            if (r < n && nums[r] > nums[mix]) {
                mix = r;
            }
            if (i == mix) {
                break;
            }
            swap(nums,i,mix);
            i = mix;
        }

    }

}
