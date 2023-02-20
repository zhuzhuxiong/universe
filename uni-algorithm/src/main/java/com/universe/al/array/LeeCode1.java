package com.universe.al.array;

import java.util.HashMap;

/**
 * 两数之和 (两个数不可重复)
 * 返回[0,1]形式下标
 * 1、双循环 内循环条件 j=i+1
 * 2、利用map （k-v 分别代表的含义） 单循环 map.containsKey(target-nums[i])
 * @author lx
 */
public class LeeCode1 {

    /**
     * 双循环 j=i+1;
     * @param nums
     * @param target
     * @return
     */
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }

        }
        return new int[]{};
    }

    /**
     * 利用map，key-数值，value-下标
     * 利用target - num[i] 单次循环对比单值
     * @param nums
     * @param target
     * @return
     */
    public int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
