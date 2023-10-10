package com.universe.al.queue;

import com.universe.al.linked.ListNode;

import java.util.LinkedList;

/**
 * @author l
 */
public class QueueLinked {

    private ListNode front, rear;
    private int queueSize = 0;

    public QueueLinked(){
        front = null;
        rear = null;
    }

    public int size(){
        return queueSize;
    }

    public boolean isEmpty(){
        return queueSize == 0;
    }

    public void push(int num){
        ListNode node = new ListNode(num);
        if (front == null) {
            front = node;
            rear = node;
        }else {
            rear.next = node;
            rear = node;
        }
        queueSize++;
    }

    public int peek(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    public int pop(){
        int peek = peek();
        front = front.next;
        queueSize --;
        return peek;
    }


    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        //作为队列使用时，入队方法
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("queue: " + queue);
        System.out.println("queue size: " + queue.size());
        Integer peek = queue.peek();
        System.out.println("peek: " + peek);

        Integer poll = queue.poll();
        System.out.println("poll: " + poll);

        boolean empty = queue.isEmpty();
        System.out.println("empty: " + empty);

        QueueLinked linked = new QueueLinked();
        linked.push(1);
        linked.push(2);
        linked.push(3);
        linked.push(4);

        com.universe.al.linked.LinkedList.print(linked.front);

        int peek1 = linked.peek();
        System.out.println("peek1: " + peek1);

        int pop = linked.pop();
        System.out.println("pop: " + pop);
        com.universe.al.linked.LinkedList.print(linked.front);

        System.out.println(linked.size());
        System.out.println(linked.isEmpty());

    }



}
