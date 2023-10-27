package com.universe.al.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 */
public class ArrayBinaryTree {

    private List<Integer> tree;

    public ArrayBinaryTree(List<Integer> arr) {
        this.tree = new ArrayList<>(arr);
    }

    public int size() {
        return tree.size();
    }

    public Integer val(int i) {
        if (i < 0 || i >= size()) {
            return null;
        }
        return tree.get(i);
    }

    public Integer left(int i) {
        return 2 * i + 1;
    }

    public Integer right(int i) {
        return 2 * i +2;
    }

    public List<Integer> levelOrder(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i) != null) {
                list.add(val(i));
            }
        }
        return list;
    }

    public void dfs(int i, String order, List<Integer> res) {
        if (val(i) != null) {
            return;
        }
        if ("pre".equals(order)) {
            res.add(val(i));
        }
        dfs(left(i), order,res);
        if ("in".equals(order)) {
            res.add(val(i));
        }
        dfs(right(i),order,res);
        if ("post".equals(order)) {
            res.add(val(i));
        }
    }






    public static void main(String[] args) {

    }
}
