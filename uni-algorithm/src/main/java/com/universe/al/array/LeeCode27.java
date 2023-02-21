package com.universe.al.array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素
 * ，并返回移除后数组的新长度。
 * 雷同L26 指针的起始条件不同
 * @author l
 */
public class LeeCode27 {

    public static void main(String[] args) {

    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int solution(int[] nums,int val){

        if (null == nums || nums.length == 0){
            return 0;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }
}
