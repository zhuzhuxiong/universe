package com.universe.al.search;

import com.fasterxml.jackson.core.sym.NameN;

import java.util.HashMap;

/**
 * 二分
 *
 * @author l
 */
public class BinarySearch {

    /**
     * 给定有序数组nums，找有无target值，返回index，无：-1；
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        /**
         * 双闭区间：[0,length -1] <= ；j=m-1;i=m+1;（建议使用）
         * 左闭右开：[0,length] < ; i=m+1;j=m;
         *
         */
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] > target) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 无重复元素的有序数据nums，插入target，原数组有target，则插入在左侧；
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] > target) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        //区别：返回i
        return i;
    }

    /**
     * 有重复元素的有序数据nums，插入target，原数组有target，则插入在左侧；
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] > target) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                //区别：nums[m] == target 时，利用j->i靠近来找最左侧的index，j=m-1;{1,2,3,3,3,3,4}
                j = m - 1;
            }
        }
        return i;
    }

    /**
     * 【最左边界】有序数组nums，返回数组最左一个target的index；无：-1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchEdgeLeft(int[] nums, int target) {
        int index = binarySearch2(nums, target);
        if (index == nums.length || nums[index] != target) {
            return -1;
        }
        return index;
    }

    /**
     * 【最右边界】有序数组nums，返回数组最右一个target的index；无：-1
     * tip: 找最左的【target+1】
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchEdgeRight(int[] nums, int target) {
        /** 查找最左的 target+1 */
        int index = binarySearch2(nums, target + 1);
        int j = index - 1;
        if (j == -1 || nums[j] != target) {
            return -1;
        }
        return index;
    }

    /**
     * 有序数组nums，返回加和等于target的元素下标。
     * tip：线性查找：时间换空间，双循环
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] linear(int[] nums, int target) {
        int length = nums.length;
        /**外层length-1：最后一个数会被加到 无法主动加比他更靠后的元素了*/
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 有序数组nums，返回加和等于target的元素下标。
     * 利用辅助Hash表
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] hashAssist(int[] nums, int target) {
        int length = nums.length;
        /** key: nums的元素值，value：元素下标 */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        int i = binarySearch(nums, 4);
        System.out.println(i);
        int i1 = binarySearchEdgeLeft(nums, 9);
        System.out.println(i1);
        int i2 = binarySearchEdgeRight(nums, 9);
        System.out.println(i2);
        int[] linear = linear(nums, 9);
        System.out.println(linear[0] + "；" + linear[1]);
        int[] ints = hashAssist(nums, 9);
        System.out.println(ints[0] + "；" + ints[1]);

    }
}
