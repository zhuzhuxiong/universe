package com.universe.al.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历
 *
 * @author l
 */
public class BinaryTreePre {


    public static void main(String[] args) {

    }

    /**
     * 前序遍历-print值-递归
     */
    public static void preOrderRecursionPrint(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        preOrderRecursionPrint(root.left);
        preOrderRecursionPrint(root.right);
    }

    /**
     * 前序遍历-print值-遍历
     * stack
     * @param tree
     */
    public void preOrderTraversalPrint(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (null != node.left) {
                stack.push(node.left);
            }
            if (null != node.right) {
                stack.push(node.right);
            }
        }
    }

    /**
     * 前序遍历-递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        preOrder1(root, list);
        return list;
    }

    public void preOrder1(TreeNode tree, List<Integer> list) {
        if (null == tree) {
            return;
        }
        list.add(tree.val);
        preOrder1(tree.left, list);
        preOrder1(tree.right, list);
    }

    /**
     * 前序遍历-遍历
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            //栈特性：先进后出，所以先放右，list的顺序才是从小到大
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * Morris ToDo
     * @param root
     * @return
     */
    public List<Integer> preOrderMorris(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;

        //当前节点不为空
        while (null != cur) {

            //当前节点无左子节点；即没有比当前节点小的值，放cur，向右节点遍历
            if (null == cur.left) {
                list.add(cur.val);
                cur = cur.right;
            }else {
                //向左走
                TreeNode pre = cur.left;
                // ?
                while (null != pre.right && pre.right != cur) {
                    pre = pre.right;
                }

                //无右节点，那右边就是父节点
                if (null == pre.right) {
                    pre.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                }else {

                    //?
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return list;
    }

}
