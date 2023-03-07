package com.universe.al.tree;

/**
 * 树-节点
 * 值+左子节点+右子节点+无参构造+有参构造
 *
 * @author lx
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int value) {
        this.val = value;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
