package com.universe.al.backtracking;

import com.universe.al.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 * @author l
 */
public class BacktrackingAlgorithm {

    /**
     * 搜索二叉树，返回节点值为 7 的节点列表。
     *
     * @param root
     */
    public static List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public static void preOrder(TreeNode root, List res) {
        if (null == root) {
            return;
        }
        if (root.val == 7) {
            res.add(root.val);
        }
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    /***
     * 【回溯】--【尝试与回退】
     * 搜索二叉树，【根节点 到-> 节点值为7】 的路径列表
     * @param root
     * @return
     */
    public static List<List<Integer>> solution1(TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        List<List<TreeNode>> record = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        preOrder1(root, path, record);
        for (List<TreeNode> treeNodes : record) {
            List<Integer> tmp = new ArrayList<>();
            for (TreeNode treeNode : treeNodes) {
                tmp.add(treeNode.val);
            }
            res.add(tmp);
        }
        return res;
    }

    private static void preOrder1(TreeNode root, List<TreeNode> path, List<List<TreeNode>> record) {
        if (null == root) {
            return;
        }
        path.add(root);
        if (7 == root.val) {
            record.add(new ArrayList<>(path));
        }
        preOrder1(root.left, path, record);
        preOrder1(root.right, path, record);
        path.remove(path.size() - 1);
    }

    /**
     * 【回溯】-- 【剪枝】
     * 搜索二叉树，【根节点 到-> 节点值为7 ,并且路径中节点不等于3 】 的路径列表
     * @param root
     * @return
     */
    public static List<List<Integer>> solution2(TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        List<List<TreeNode>> record = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        preOrder2(root, path, record);
        for (List<TreeNode> treeNodes : record) {
            List<Integer> tmp = new ArrayList<>();
            for (TreeNode treeNode : treeNodes) {
                tmp.add(treeNode.val);
            }
            res.add(tmp);
        }
        return res;
    }

    private static void preOrder2(TreeNode root, List<TreeNode> path, List<List<TreeNode>> record) {
        /** 剪枝：检测到不符合要求的条件，立即结束 */
        if (root == null || root.val == 3) {
            return;
        }
        path.add(root);
        if (root.val == 7) {
            record.add(new ArrayList<>(path));
        }
        preOrder2(root.left, path, record);
        preOrder2(root.right, path, record);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.listToTree(Arrays.asList(1, 7, 3, 4, 5, 6, 7));
        List<Integer> list = solution(node);
        System.out.println(list);

        List<List<Integer>> lists = solution1(node);
        System.out.println(lists);

        List<List<Integer>> list2 = solution2(node);
        System.out.println(list2);
    }
}
