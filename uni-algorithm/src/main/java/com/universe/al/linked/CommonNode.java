package com.universe.al.linked;

/**
 * 剑指offer 52：输入两个链表，找出它们的第一个公共节点。
 */
public class CommonNode {

    public ListNode solution(ListNode head1,ListNode head2){
        ListNode node1 = head1,node2 = head2;
        while (node1 != node2){
            node1 = node1 != null ? node1.next : head2;
            node2 = node2 != null ? node2.next :head1;
        }
        return node1;
    }
}
