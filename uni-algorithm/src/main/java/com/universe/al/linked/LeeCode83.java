package com.universe.al.linked;

/**
 * 删除链表中重复元素
 * @author L
 */
public class LeeCode83 {

    public static void main(String[] args) {

    }

    /**
     * 单次循环
     * @author l
     * @date  2023/2/27 14:36
     * @param head
     * @return com.universe.al.linked.ListNode
     **/
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode cur = head;
        while (null != cur.next){
            if (cur.next.val == cur.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
