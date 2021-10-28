package com.universe.linked;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * @author
 *
 * 双指针
 */
public class DelNode {

    /**
     * 双指针 删除单链表节点
     * pre.next = cur.next
     * 节点循环
     * cur != null && cur.var != val
     * 移动指针
     * pre = cur；cur = cur.next
     */
    public ListNode solution(ListNode head,int val){
        if (head.val == val){ return head.next;}
        ListNode pre = head,cur = head.next;
        while (cur != null || cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }
}

