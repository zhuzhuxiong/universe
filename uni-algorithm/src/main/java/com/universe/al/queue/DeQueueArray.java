package com.universe.al.queue;

import java.util.Arrays;

/**
 * @author l
 *
 */
public class DeQueueArray {

    private int[] nums;
    private int front;
    private int size;

    public DeQueueArray(int capacity) {
        nums = new int[capacity];
        front = size = 0;
    }

    /** 核心，通过传入的位置取余，获得在循环数组的真实位置，即越过头，尾完成循环功能 */
    private int index(int i) {
        return (i + nums.length) % nums.length;
    }

    public void pushFirst(int num) {
        if (size == nums.length) {
            return;
        }
        front = index(front - 1);
        nums[front] = num;
        size++;
    }

    public void pushLast(int num) {
        if (size == nums.length) {
            return;
        }
        int rear = index(front + size);
        nums[rear] = num;
        size++;
    }

    public int peekFirst(){
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    public int popFirst() {
        int first = peekFirst();
        front = index(front + 1);
        size--;
        return first;
    }

    public int peekLast(){
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
       return nums[index(front+size-1)];
    }

    public int popLast() {
        int last = peekLast();
        size--;
        return last;
    }

    public static void main(String[] args) {
        DeQueueArray array = new DeQueueArray(5);

        array.pushFirst(2);
        array.pushFirst(1);
        array.pushLast(3);
        array.pushLast(4);
        array.pushLast(5);

        System.out.println(Arrays.toString(array.nums));

        System.out.println(array.popFirst());

        array.pushLast(6);
        System.out.println(Arrays.toString(array.nums));

        System.out.println(array.popLast());
    }

}
