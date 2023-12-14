package com.universe.al.sort;

import java.util.Arrays;

/**
 * @author l
 */
public class CountingSort {

    /** 简单实现，限定（非负整数）*/
    public static void solutionNaive(int[] nums) {
        /** 找最大值 */
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        /*** counter 数组 [0,1,1,1,0] 代表 有0个0，1个1，1个2... 天然带顺序*/
        int[] counter = new int[max + 1];
        for (int num : nums) {
            counter[num]++;
        }

        /** 外循序：循环counter数组，0,1,2,3...
         *  内循环：循序每个数字有几个
         * */
        int i = 0;
        for (int j = 0; j < max + 1; j++) {
            for (int k = 0; k < counter[j]; k++, i++) {
                nums[i] = j;
            }
        }
    }

    /**
     * 完整实现，限定（非负整数）
     * 时间复杂度：O(n+m),一般n >> m.即O(n)
     * 空间复杂度：O(n+m),借助了 counter[m],res[m];
     * 非原地排序
     * 稳定排序
     *
     * @param nums
     */
    public static void solutionMature(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] counter = new int[max + 1];
        for (int num : nums) {
            counter[num]++;
        }

        /** 求前缀和 counter[num] - 1 是num在res中最后一次出现的索引 */
        for (int i = 0; i < max; i++) {
            counter[i+1] = counter[i+1] + counter[i];
        }

        int length = nums.length;
        int[] res = new int[length];
        /** 反向遍历 */
        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i];
            res[counter[num] - 1] = num;
            counter[num]--;
        }

        /** 数据覆盖 */
        for (int i = 0; i < length; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        solutionNaive(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        solutionMature(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums1 = {1, 3, 7, 9, 8, 5, 3, 2, 6};
        practice(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    
    public static void practice(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        
        int[] counter = new int[max + 1];
        for (int num : nums) {
            counter[num]++;
        }
        
        int i = 0;
        for (int j = 0; j < max + 1; j++) {
            for (int k = 0; k < counter[j]; k++,i++) {
                nums[i] = j;
            }
        }
    }
}
