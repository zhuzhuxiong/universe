package com.universe.linked;

/**
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
            list1.next = solution(list1.next, list2);
            return list1;
        }else {
            list2.next = solution(list1, list2.next);
            return list2;
        }
    }

    /**
     * todo 懒得学 等补--MixNode.java
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution2(ListNode list1, ListNode list2){
        ListNode pre = new ListNode(-1);
        ListNode head = pre;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val) {

            }
        }

        return pre.next;
    }


}
