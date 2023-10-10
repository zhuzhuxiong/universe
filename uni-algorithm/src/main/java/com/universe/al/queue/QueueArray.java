package com.universe.al.queue;

import java.util.Arrays;

/**
 * @author l
 */
public class QueueArray {

    private int[] nums;
    private int front;
    private int size;

    public QueueArray(int capacity) {
        nums = new int[capacity];
        front = size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return nums.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(int num) {
        if (size == capacity()) {
            System.out.println("满了啊");
            return;
        }
        /** 使得指针可以循环到数组头部 */
        int rear = (front + size) % capacity();
        nums[rear] = num;
        size++;
    }

    public int pop() {
        int peek = peek();
        front = (front + 1) % capacity();
        size--;
        return peek;
    }

    public int peek(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    public static void main(String[] args) {
        QueueArray array = new QueueArray(4);

        array.push(1);
        array.push(2);
        array.push(3);

        System.out.println(Arrays.toString(array.nums));

        int peek = array.peek();
        System.out.println(peek);

        int pop = array.pop();
        System.out.println(pop);

        array.push(4);
        array.push(5);
        System.out.println(Arrays.toString(array.nums));
        System.out.println(array.size);




    }


}
