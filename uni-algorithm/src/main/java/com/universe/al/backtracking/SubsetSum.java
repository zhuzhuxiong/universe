package com.universe.al.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author l
 */
public class SubsetSum {

    /**
     * 给定非负整数数组nums，返回加和等于target的子集list，元素可重复使用，子集元素只有顺序不同视为相同解。
     * 【无重复】全排列的方式
     * 结果：[[3, 3, 3], [4, 5], [5, 4]]
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> solutionNaive(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int total = 0;
        ArrayList<Integer> state = new ArrayList<>();
        backTrack(state, target, total, nums, res);
        return res;
    }

    public static void backTrack(List<Integer> state, int target, int total, int[] choices, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = 0; i < choices.length; i++) {
            /** 不能在if前：total += choices[i] ，然后用total 替换 total + choices[i]；下面递的地方也是 */
            if (total + choices[i] > target) {
                continue;
            }
            state.add(choices[i]);
            backTrack(state, target, total + choices[i], choices, res);
            state.remove(state.size() - 1);
        }
    }

    /**
     * 【无重复】能过滤重复结果集的方法
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> solution1(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0;
        backTrack1(new ArrayList<>(), start, target, nums, res);
        return res;
    }

    /**
     * @param start 从start开始遍历，避免重复子集
     * @param target target 做减法 = 即为正解
     */
    public static void backTrack1(List<Integer> state, int start, int target, int[] choices, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        /** 从start 开始遍历 [3,4,5] 4已经在结果集中【4,5】，后面5在前面是就跳过4 */
        for (int i = start; i < choices.length; i++) {
            /** 做了排序，小数不符合，后面的更不符合 break */
            if (target - choices[i] < 0) {
                break;
            }
            state.add(choices[i]);
            backTrack1(state, i, target - choices[i], choices, res);
            state.remove(state.size() - 1);
        }
    }

    /**
     * 【有重复】元素的数组nums，子集和等于target
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> solution2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        Arrays.sort(nums);
        backTrack2(new ArrayList<>(),start,target,nums,res);
        return res;
    }

    public static void backTrack2(List<Integer> state, int start, int target, int[] nums, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                break;
            }
            /**元素和左边的相等，相等元素判断，跳过*/
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            state.add(nums[i]);
            backTrack2(state,i+1,target-nums[i],nums,res);
            state.remove(state.size()-1);
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5};
        System.out.println(solutionNaive(nums, 9));

        System.out.println(solution1(nums, 9));

        int[] nums1 = new int[]{4, 4, 5};
        System.out.println(solution2(nums1, 9));
    }
}
