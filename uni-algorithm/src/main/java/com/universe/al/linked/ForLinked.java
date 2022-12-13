package com.universe.al.linked;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指offer 06
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ForLinked {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
         listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

    }

    //获取链表长度，反向插入数组
    public int[] reversePrint(ListNode head) {
        //链表长度
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        //新建数组放结果
        int[] array = new int[count];
        cur = head;
        count--;
        while (cur != null && count >= 0) {
            array[count--] = cur.val;
            cur = cur.next;
        }
        return array;
    }

    //同上，用栈的方式放入result
    public int[] reversePrintByStack(ListNode head) {
        //获取链表长度,节点放到栈里
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        //新建结果数组，pop存储数组
        int[] array = new int[stack.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    //递归
    ArrayList<Integer> integers = new ArrayList<>();
    public int[] resverse(ListNode head){

        res(head);

        int[] array = new int[integers.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = integers.get(i);
        }
        return array;
    }

    private void res(ListNode head) {
        while (head == null) return;
        res(head.next);
        integers.add(head.val);
    }

    /**
     * [1,2,3,4,5]
     * []
     * @param head
     * @return
     */


}



