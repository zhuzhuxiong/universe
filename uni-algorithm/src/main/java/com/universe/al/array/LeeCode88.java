package com.universe.al.array;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 合并两个有序数组
 * 1、先合并，再排序
 * 2、
 *
 * @author l
 */
public class LeeCode88 {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.println(LocalDateTime.MAX);
        }
    }

    /**
     *
     * @author l
     * @date  2023/2/23 16:32
     * @param nums1 数组1
     * @param m 数组一有效长度
     * @param nums2 数组2
     * @param n 数组2长度
     * @return void
     **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针，+新空间
     * */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //定义指针
        int p =0 ,q = 0;
        //新数组
        int[] sort = new int[m+n];
        //当前值
        int cur;
        //两个指针都循环完
        while (p < m || q < n) {
            //num1 为空或结束 只拼num2
            if (p == m) {
                cur = nums2[q++];
            }else if (q == n) {
                cur = nums1[p++];
                //num1小，排1的值，并且++
            }else if (nums1[p] < nums2[q]) {
                cur = nums1[p++];
            }else {
                cur = nums2[q++];
            }
            //向新数组放值，因为每个都自动++，所以需要-1
            sort[p+q-1] = cur;
        }

        //放回原来的num1
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sort[i];
        }

    }

    /**
     * todo
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {

    }

}
