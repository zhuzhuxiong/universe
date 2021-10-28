package com.universe.linked;


/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class MixNode {

    /**
     * 双指针
     * 定义一个虚拟的头结点，以此向后插入，当l1，l2 都不为null时循序插入
     * 单独剩余的l1 或 l2 直接补充在后边
     * 返回虚拟头结点（head）以后的链表
     * @param l1 链表1
     * @param l2 链表2
     * @return listNode
     */
    public ListNode solution(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0), cur = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
