package com.universe.al.queue;

import com.universe.al.linked.DeListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author
 */
public class DoubleEndedQueue {

    private DeListNode front, rear;
    private int size;

    public DoubleEndedQueue(){
        rear = front = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void pushFirst(int num){
        push(num, true);
    }

    public void pushLast(int num) {
        push(num, false);
    }

    private void push(int num, boolean isFront) {
        DeListNode node = new DeListNode(num);
        if (isEmpty()) {
            front = rear = node;
        }else if (isFront) {
            front.prev = node;
            node.next = front;
            front = node;
        }else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        size++;
    }

    public int popFirst(){
        return pop(true);
    }

    public int popLast(){
        return pop(false);
    }

    private int pop(boolean isFront){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int val;
        if (isFront) {
            val = front.val;
            DeListNode fNext = front.next;
            if (null != fNext) {
                fNext.prev = null;
                front.next = null;
            }
            front = fNext;
        }else {
            val = rear.val;
            DeListNode rPrev = rear.prev;
            if (null != rPrev) {
                rear.prev = null;
                rPrev.next = null;
            }
            rear = rPrev;
        }
        size--;
        return val;
    }

    public static void print(DeListNode node){
        ArrayList<Integer> list = new ArrayList<>();
        while (null != node) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        LinkedList<Integer> dequeue = new LinkedList<>();

        dequeue.offerLast(3);
        dequeue.offerFirst(2);
        dequeue.offerLast(4);
        dequeue.offerFirst(1);

        System.out.println(dequeue);

        System.out.println(dequeue.peekFirst());
        System.out.println(dequeue.peekLast());

        System.out.println(dequeue.pollFirst());
        System.out.println(dequeue.pollLast());

        System.out.println(dequeue.size());
        System.out.println(dequeue.isEmpty());

        DoubleEndedQueue queue = new DoubleEndedQueue();
        queue.pushFirst(1);
        queue.pushFirst(2);
        queue.pushLast(3);
        queue.pushLast(4);
        print(queue.front);

        System.out.println(queue.popFirst());
        System.out.println(queue.popLast());
        print(queue.front);

    }
}
