package com.universe.al.structure;

import java.util.Arrays;

/**
 * 快速排序--0914
 */
public class FastSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,2,4};
//        fastSort(nums,0,nums.length-1);
        int[] ints = getLeastNums(nums, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void fastSort(int[] nums,int left,int right){
       //递归终止判断
        if (left >= right){
            return;
        }
        int i =left,j = right;
        //首次循环i  以 nums[left] 为基准
        while (i < j){
            while (i < j && nums[j] >= nums[left]){
                j--;
            }
            while (i < j && nums[i] <= nums[right]){
                i++;
            }
            swap(nums,i,j);
        }
        swap(nums,i,left);
        //分左右递归
        fastSort(nums,left,i-1);
        fastSort(nums,i+1,right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] getLeastNums(int[] nums,int k){
        if (k >= nums.length){return nums;}
        return quickList(nums,k,0,nums.length-1);
    }

    public static int[] quickList(int[] nums,int k,int le,int ri){
//        int i = le,j = ri;
//        while (i < j) {
//            while (i < j && nums[j] >= nums[le] ){j--;}
//            while (i < j && nums[i] <= nums[le] ){i++;}
//            swap(nums,i,j);
//        }
//        swap(nums,i,le);
////        if (i > k) {return quickList(nums,k,le,i-1);}
////        if (i < k) {return quickList(nums,k,i+1,ri);}
////        return Arrays.copyOf(nums,k);
//        if (i > k) return quickList(nums, k, le, i - 1);
//        if (i < k) return quickList(nums, k, i + 1, le);
//        return Arrays.copyOf(nums, k);

        int i = le,j=ri;
        while (i<j){
            while (i<j && nums[j] > nums[le]) j--;
            while (i<j && nums[i] < nums[le]) i++;
            swap(nums,i,j);
        }
        swap(nums,i,le);
        if (i > k) return quickList(nums,k,le,i-1);
        if (i < k) return quickList(nums,k,i+1,ri);
        return Arrays.copyOf(nums,3);
    }







}
