package com.universe.al.array;

/**
 * 26. 删除有序数组中的重复项（不能开辟新的空间）
 * @author l
 */
public class LeeCode26 {

    public static void main(String[] args) {

    }

    /**
     * 双指针： 一 fast 一 slow；
     * fast做循环；slow做收集；
     *
     * 循环 fast++；
     * 符合条件 slow++ 计数收集；
     *
     * @param nums
     * @return
     */
    public int solution(int[] nums){

        if (null == nums || nums.length == 0){
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < nums.length){
            if (nums[fast] != nums[fast - 1]){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }

}
