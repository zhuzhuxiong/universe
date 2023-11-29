package com.universe.al.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author l
 */
public class JavaHeap {

    /** 应用 获取给定数组前k个最大，最小元素 */
    Queue<Integer> topKHeap(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue;
    }

    public static void main(String[] args) {

        /** 小顶堆 */
        PriorityQueue<Integer> queue = new PriorityQueue<>(Arrays.asList(1,3,5,4,2));
        /** 大顶堆 */
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((a, b) -> b - a);

        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Integer::compareTo);

        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue1.offer(4);

        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(3);
        queue2.offer(4);

        System.out.println(queue1.poll());

        System.out.println(queue1.size());

        System.out.println(queue1.isEmpty());


        while (!queue.isEmpty()){
            System.out.println("queue: " + queue.poll());
        }


        System.out.println(queue1.peek());
        System.out.println(queue2.peek());

    }


}
