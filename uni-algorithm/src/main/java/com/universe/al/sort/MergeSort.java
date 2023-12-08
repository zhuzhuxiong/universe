package com.universe.al.sort;

import java.util.Arrays;

/**
 * @author l
 */
public class MergeSort {

    public static void solution(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            solution(nums, left, mid);
            solution(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }
    }

    public static void merge(int[] nums, int left, int right, int mid) {
        int[] tmp = new int[right - left + 1];
        /** i:左子数组起始；j:右子数组起始；*/
        int i = left, j = mid + 1, k = 0;
        /** 左右子数组同时有数据时，元素值小的先复制到tmp*/
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        /** 只剩左子数组时，将剩余元素复制到tmp*/
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        /** 同上 */
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        /**tmp 复制回原数组*/
        for (int l = 0; l < tmp.length; l++) {
            nums[left + l] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        solution(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        practice(nums1, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void practice(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            practice(nums, left, mid);
            practice(nums, mid + 1, right);
            merge1(nums, left, mid, right);
        }
    }

    public static void merge1(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            }else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (int l = 0; l < tmp.length; l++) {
            nums[left + l] = tmp[l];
        }
    }


}
