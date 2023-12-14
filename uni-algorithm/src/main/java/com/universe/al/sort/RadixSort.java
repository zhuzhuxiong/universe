package com.universe.al.sort;

import java.util.Arrays;

/**
 * 基数排序
 * @author l
 */
public class RadixSort {

    public static void solution(int[] nums) {
        /** 找最大 */
        int m = 0;
        for (int num : nums) {
            m = Math.max(num, m);
        }

        /**[10546151] 从个位开始倒序遍历，i=1个位，1=10十位*/
        for (int i = 1; i < m; i = i * 10) {
            countingSortDigit(nums, i);
        }
    }

    public static void countingSortDigit(int[] nums, int exp) {
        /** 十进制 0-9 */
        int[] counter = new int[10];
        int l = nums.length;
        /** 统计 0-9 每个数出现的次数*/
        for (int i = 0; i < l; i++) {
            /** 获取nums[i]的第K位，从个位开始 */
            int d = digit(nums[i], exp);
            /**统计d出现的次数*/
            counter[d]++;
        }
        /**计算前缀和 */
        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i-1];
        }

        int[] res = new int[l];
        /** 对数组元素的相同位数（个，十。。。）进行排序 */
        for (int i = l - 1; i >= 0; i--) {
            int d = digit(nums[i], exp);
            int j = counter[d] - 1;
            res[j] = nums[i];
            counter[d]--;
        }
        for (int i = 0; i < l; i++) {
            nums[i] = res[i];
        }
    }

    /** exp = 10 ^ (k-1) */
    public static int digit(int num, int exp) {
        /** 避免次方运算，exp = 1时，取个位*/
        return (num / exp) % 10;
    }

    public static void main(String[] args) {
        int[] nums = { 10546151, 35663510, 42865989, 34862445, 81883077,
                88906420, 72429244, 30524779, 82060337, 63832996 };
        solution(nums);
        System.out.println("基数排序完成后 nums = " + Arrays.toString(nums));

        System.out.println(digit(10546157, 1));
    }


}
