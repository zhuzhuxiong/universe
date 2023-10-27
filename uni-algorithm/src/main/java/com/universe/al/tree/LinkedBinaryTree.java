package com.universe.al.tree;

/**
 * @author
 */
public class LinkedBinaryTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        /** 初始化 */
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node0 = new TreeNode(0);

        /** 插入 */
        node1.left = node0;
        node0.left = node2;

        /** 删除 */
        node1.left = node2;
    }

}
