package com.universe.al.sort;

public class Search {

    public static void main(String[] args) {

    }

    public static int solution(int[] nums, int target){
        int right = nums.length-1;
        int left = 0;

        while (left <= right){
            int mid = (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid;
            }else {
                left = mid;
            }
        }
        return -1;
    }
}
