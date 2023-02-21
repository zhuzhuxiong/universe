package com.universe.al.linked;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 1、递归 找到结束点、找到循环点
 * 2、迭代 建立一个新链表，两个链表往新的里加
 *
 * @author L
 */
public class LeeCode21 {

    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param list1 1
     * @param list2 2
     * @return l
     */
    public ListNode solution(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }else if (list1.val < list2.val){
            //list1 小，就指向list1.next
            list1.next = solution(list1.next, list2);
            return list1;
        }else {
            list2.next = solution(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution2(ListNode list1, ListNode list2){
        //新链表的指针 头
        ListNode preNode = new ListNode(-1);

        ListNode pre = preNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                //往后走
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        // 其中一个走完，另一的后续直接补充在后边
        pre.next = list1 == null ? list2 :list1;

        //完整的新链表从头往后指☞
        return preNode.next;
    }


}
