package com.universe.array;

/**
 * @author
 */
public class LeeCode26 {

    public static void main(String[] args) {

    }

    /**
     * 双指针： 一 fast 一 slow；
     * fast做循环；slow做收集；
     *
     * 循环条件：not for for for；
     * while（）：left < right; fast < lenth;
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
