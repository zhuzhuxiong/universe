package com.universe.array;

import java.util.HashMap;

/**
 * 两数之和
 * 返回[0,1]形式下标
 */
public class LeeCode1 {

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
