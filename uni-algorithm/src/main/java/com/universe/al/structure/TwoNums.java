package com.universe.al.structure;

import java.util.HashMap;

/**
 * 0913-LC-两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * https://leetcode-cn.com/problems/two-sum/
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNums {

    public static void main(String[] args) {

//        int[] nums = new int[5];
//        nums[0] = 1;
//        int[] nums = {1,2,3};
        int[] nums = new int[] {1,2,3};
//        solutionEnum()
    }

    /**
     * 穷举 O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solutionEnum(int[] nums, int target){
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i +1 ; j < length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    /**
     * 辅助hash表
     * @param nums
     * @param target
     * @return
     */
    public static int[] solutionHash(int[] nums, int target){
        int length = nums.length;
        //key-nums[i],val-i; num[i]做key 好做判断
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }


}
