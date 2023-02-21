package com.universe.al.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @author l
 */
public class LeeCode35 {

    public static void main(String[] args) {
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert0(int[] nums, int target){
        // 左 = 0，右 = l - 1;
        int left = 0,right = nums.length-1;
        //左 <= 右
        while (left <= right) {
            //中间值
            int mid = (left + right) / 2;
            //直接符合条件
            if (nums[mid] == target) {
                return mid;
            }
            // 左 = 中 +1 ；右 = 中 - 1；
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        //返回左
        return left;
    }

    /**
     * 自写 略过
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (null == nums || 0 == nums.length){
            return 0;
        }
        int fast = 0;
        while (fast < nums.length) {
            if (target == nums[fast]){
                return fast;
            }
            if (target < nums[0]){
                return 0;
            }
            if (target > nums[nums.length - 1]) {
                return nums.length;
            }
            if (target > nums[fast] && target< nums[fast +1]){
                return fast +1;
            }
            fast++;
        }
        return fast;
    }
}
