package com.universe.linked;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ForLinked {

    public static void main(String[] args) {

    }

//    public int[] reversePrint(ListNode head) {
//        while (head.next != null){
//            ListNode temp = head.next.next;
//            head.next.next = head.next;
//            head.next = head;
//
//        }
//
//    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
