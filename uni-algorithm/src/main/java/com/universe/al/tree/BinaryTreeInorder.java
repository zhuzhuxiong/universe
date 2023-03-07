package com.universe.al.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树遍历 - 中序
 *
 * @author l
 */
public class BinaryTreeInorder {


    public static void main(String[] args) {

    }

    /**
     * 中序遍历-print值-递归
     */
    public static void inorderRecursionPrint(TreeNode root) {
        if (null == root) {
            return;
        }
        inorderRecursionPrint(root.left);
        System.out.println(root.val);
        inorderRecursionPrint(root.right);
    }

    /**
     * 中序遍历-print值-遍历
     * stack
     * @param tree
     */
    public void inorderTraversalPrint(TreeNode tree) {

    }

    /**
     * 中序遍历-递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderRecursion(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(root,list);
        return list;
    }

    public void inorder(TreeNode tree, List<Integer> list) {
        if (null == tree) {
            return;
        }
        inorder(tree.left,list);
        list.add(tree.val);
        inorder(tree.right,list);
    }

    /**
     * 中序遍历-遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){

        return null;
    }

    /**
     * 中序遍历- Morris ToDo
     * @param root
     * @return
     */
    public List<Integer> inorderMorris(TreeNode root) {
        return null;
    }

}
