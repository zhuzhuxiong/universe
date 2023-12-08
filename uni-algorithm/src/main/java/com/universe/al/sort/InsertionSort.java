package com.universe.al.sort;

import java.util.Arrays;

/**
 * @author l
 */
public class InsertionSort {

    public static void solution(int[] nums) {
        /** 向nums[0]开始插入数据 */
        for (int i = 1; i < nums.length; i++) {
            /** base：临时存储将要插入的数据，j 是base前一个数据，被插的区域  */
            int base = nums[i], j = i - 1;
            /** 在数组范围内；跟被插的区域的元素对比，大于base，base需要插入*/
            while (j >= 0 && nums[j] > base) {
                /** 大数右移一位 ，向左循环对比*/
                nums[j + 1] = nums[j];
                j--;
            }
            /** 该右移的都完成后，base落位 */
            nums[j + 1] = base;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 7, 9, 8, 5, 4, 2, 6};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
