package com.universe.al.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 数组基本操作
 * @author l
 */
public class Array {

    public static void main(String[] args) {
        //初始化
        int[] arr = new int[5];
        System.out.println("arr===" + Arrays.toString(arr));
        int[] arr1 = new int[]{1,2,3,4,5};
        System.out.println("arr1===" + Arrays.toString(arr1));
        int[] nums = {1,2,3,4,5};
        System.out.println("nums===" + Arrays.toString(nums));

        insert(nums, 8, 1);
        System.out.println("插入操作后nums===" + Arrays.toString(nums));

        remove(nums, 2);
        System.out.println("删除操作后nums===" + Arrays.toString(nums));

        traverse(nums);

        int i = find(nums, 3);
        System.out.println("查找目标元素下标i===" + i);

        int access = randomAccess(nums);
        System.out.println("随机访问===" + access);

    }


    /**
     * 插入 在数组nums的index处插入num
     */
    static void insert(int[] nums, int num, int index) {
        /** 1、index后，循环后移一位*/
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i-1];
        }
        /** 2、index处插入num*/
        nums[index] = num;
    }

    /**
     * 删除 移除index处元素
     */
    static void remove(int[] nums, int index) {
        /** 将index后的元素循序前移 忽略末尾元素值*/
        for (int i = index; i < nums.length - 1 ; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /**
     * 遍历数组
     */
    static void traverse(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("根据index遍历：" + nums[i]);
        }
        for (int num : nums) {
            System.out.println("直接遍历：" + num);
        }
    }

    /** 查找元素，返回index */
    static int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    static int[] extend(int[] nums, int capacity){
        /** 新建数组 */
        int[] newNums = new int[nums.length + capacity];
        /** 复制元素到新数组 */
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        return newNums;
    }

    static int randomAccess(int[] nums){
        /** 取随机数 */
        int index = ThreadLocalRandom.current().nextInt(0, nums.length);
        return nums[index];
    }

}
