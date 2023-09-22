package com.universe.al.linked;

import java.util.ArrayList;

/**
 * 链表基本操作
 * @author l
 */
public class LinkedList {

    public static void main(String[] args) {

        /** 初始化 1、初始化节点值；2、构建引用关系*/
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        insert(node2,new ListNode(6));
        print(node1);

        remove(node2);
        print(node1);

        ListNode access = access(node1, 1);
        System.out.println(access.val);

        System.out.println(find(node1, 8).val);

    }

    /** 插入 old --> new --> old.next*/
    static void insert(ListNode node, ListNode nodeNew) {
        nodeNew.next = node.next;
        node.next = nodeNew;
    }

    /** 删除node后首个节点 */
    static void remove(ListNode node) {
        if (node.next == null) {
            return;
        }
        node.next = node.next.next;
    }

    /** 访问索引为index的节点 */
    static ListNode access(ListNode node, int index) {
        for (int i = 0; i < index; i++) {
            if (node.next == null) {
                return new ListNode();
            }
            node = node.next;
        }
        return node;
    }

    /** 查找节点值为target的节点 */
    static ListNode find(ListNode node, int target) {
        while (node.next != null) {
            if (node.val == target) {
                return node;
            }
            node = node.next;
        }
        return new ListNode();
    }

   public static void print(ListNode header) {
        ArrayList<String> list = new ArrayList<>();
        while (header != null) {
            list.add(String.valueOf(header.val));
            header = header.next;
        }
        System.out.println(String.join("->",list));
    }

}
