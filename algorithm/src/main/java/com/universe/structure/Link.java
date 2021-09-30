package com.universe.structure;

import java.util.LinkedList;

/**
 * 队列、栈
 */
public class Link {
    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode(4);
        linkNode.next = new LinkNode(5);

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        Integer result = stack.get(1);
        System.out.println(result);
        Integer pop1 = stack.pop();
        System.out.println(pop1);
        Integer pop2 = stack.pop();
        System.out.println(pop2);

        stack.offer(11);
        stack.offer(22);
        Integer poll = stack.poll();
        System.out.println(poll);
        Integer poll2= stack.poll();
        System.out.println(poll2);


    }
}


class LinkNode{
    int value;
    LinkNode next;
    public LinkNode(int val){
        this.value = val;
    }
}