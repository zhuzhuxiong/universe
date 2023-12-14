package com.universe.al.tree;

import java.util.List;

/**
 * 树-节点
 * 值+左子节点+右子节点+无参构造+有参构造
 *
 * @author lx
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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


    /**
     * list 初始化为tree
     * @param list
     * @return
     */
    public static TreeNode listToTree(List<Integer> list) {
        return listToTreeDFS(list, 0);
    }

    private static TreeNode listToTreeDFS(List<Integer> list, int i) {
        if (i < 0 || i >= list.size() || list.get(i) == null) {
            return null;
        }
        TreeNode node = new TreeNode(list.get(i));
        node.left = listToTreeDFS(list, 2 * i + 1);
        node.right = listToTreeDFS(list, 2 * i + 2);
        return node;
    }
}
