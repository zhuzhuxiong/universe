package com.universe.al.backtracking;

import java.util.*;

/**
 * 全排列 回溯
 *
 * @author l
 */
public class PermutationAll {

    /***
     * 【无重复】数组nums, 输出全排列结果
     * @param nums
     * @return
     */
    public static List<List<Integer>> solution(int[] nums) {
        /** 结果集 */
        ArrayList<List<Integer>> res = new ArrayList<>();
        /**回溯递归方法*/
        backTrack(new ArrayList<>(), nums, new boolean[nums.length], res);
        return res;
    }

    /**
     * @param state    当前状态
     * @param choices  可选数据
     * @param selected 剪枝判断，当前元素是否已被选择过
     * @param res      返回结果
     */
    public static void backTrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        /** 全排列，当前list里数据已满，即，有一条符合要求的结果 */
        if (state.size() == choices.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        /** 遍历提供的数组 */
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            /** selected[false,false] 初始化默认false */
            if (!selected[i]) {
                /** 放入state, 置位true*/
                selected[i] = true;
                state.add(choice);
                /** 递 下一位元素 */
                backTrack(state, choices, selected, res);
                /** 归 最后一个元素开始置为false，remove出队；向前循环*/
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    /**
     * 【有重复】元素数组nums，返回无重复序列的组合。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> solution1(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backTrack1(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }

    private static void backTrack1(ArrayList<Integer> state, int[] nums, boolean[] selected, ArrayList<List<Integer>> res) {
        if (state.size() == nums.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        /** 去除重复元素，每轮递的时候都new，所以归的时候不用remove*/
        HashSet<Integer> duplicated = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int choice = nums[i];
            if (!selected[i] && !duplicated.contains(choice)) {
                state.add(choice);
                selected[i] = true;
                duplicated.add(choice);
                backTrack1(state,nums,selected,res);
                selected[i] = false;
                state.remove(state.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution(nums));
        int[] nums1 = new int[]{1, 1, 3};
        System.out.println(solution1(nums1));
    }

}
