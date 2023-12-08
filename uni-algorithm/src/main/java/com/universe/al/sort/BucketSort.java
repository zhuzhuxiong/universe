package com.universe.al.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author l
 */
public class BucketSort {

    public static void solution(float[] nums) {
        /** 初始化桶，预期一个桶放两个元素 */
        int k = nums.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }

        /** 向桶中分配元素 */
        for (float num : nums) {
            int i = (int)(num * k);
            buckets.get(i).add(num);
        }

        /** 对桶内元素进行排序 */
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        /** 合并桶 对nums重新赋值 */
        int i = 0;
        for (List<Float> bucket : buckets) {
            for (Float num : bucket) {
                nums[i++] = num;
            }
        }
    }

    public static void main(String[] args) {
        float[] nums = {0.1f, 0.3f, 0.7f, 0.9f, 0.8f, 0.5f, 0.3f, 0.2f, 0.6f};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
