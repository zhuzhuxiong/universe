package com.universe.al.stack;

import java.util.Arrays;

/**
 * @author l
 */
public class StackArray {

    private int[] nums;
    private int elementCount;

    public StackArray(){
        nums = new int[10];
        elementCount = 0;
    }

    public int size() {
        return elementCount;
    }

    public boolean isEmpty() {
        return elementCount == 0;
    }

    public void push(int num) {
        nums[elementCount] = num;
        elementCount++;
    }

    public int peek(){
        return nums[elementCount - 1];
    }

    public int pop() {
        if (elementCount == 0) {
            throw new IndexOutOfBoundsException();
        }
        int peek = peek();
        nums[elementCount-1] = 0;
        return peek;
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack:" + Arrays.toString(stack.nums));
        System.out.println("element:" + stack.elementCount);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println("stack:" + Arrays.toString(stack.nums));

    }


}
