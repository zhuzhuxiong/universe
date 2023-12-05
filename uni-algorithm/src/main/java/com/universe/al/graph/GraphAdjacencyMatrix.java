package com.universe.al.graph;

import com.universe.al.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 */
public class GraphAdjacencyMatrix {

    /** 顶点列表 元素：顶点值；索引：顶点索引 */
    List<Integer> vertices;
    /** 矩阵列表 行列索引对应顶点索引 */
    List<List<Integer>> matrix;

    public GraphAdjacencyMatrix(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.matrix = new ArrayList<>();

        /**添加顶点*/
        for (int vertex : vertices) {
            addVertex(vertex);
        }

        /** 添加边 */
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }

    }


    /** 添加顶点 */
    public void addVertex(int vertex) {
        int n = size();

        vertices.add(vertex);

        ArrayList<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newRow.add(0);
        }
        matrix.add(newRow);
        for (List<Integer> row : matrix) {
            row.add(0);
        }
    }

    /** 添加顶点 */
    public void removeVertex(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        vertices.remove(index);
        matrix.remove(index);
        for (List<Integer> row : matrix) {
            row.remove(index);
        }
    }

    public void addEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new IndexOutOfBoundsException();
        }
        matrix.get(i).set(j, 1);
        matrix.get(j).set(i, 1);
    }

    public void removeEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new IndexOutOfBoundsException();
        }
        matrix.get(i).set(j, 0);
        matrix.get(j).set(i, 0);
    }

    public int size() {
        return vertices.size();
    }

    public void print(){
        System.out.print("顶点列表 = ");
        System.out.println(vertices);
        System.out.println("邻接矩阵 =");
        PrintUtil.printMatrix(matrix);
    }

    public static void main(String[] args) {
        /* 初始化无向图 */
        // 请注意，edges 元素代表顶点索引，即对应 vertices 元素索引
        int[] vertices = { 1, 3, 2, 5, 4 };
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 3, 4 } };
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(vertices, edges);
        System.out.println("初始化后，图为");
        graph.print();

        /* 添加边 */
        // 顶点 1, 2 的索引分别为 0, 2
        graph.addEdge(0, 2);
        System.out.println("\n添加边 1-2 后，图为");
        graph.print();

        /* 删除边 */
        // 顶点 1, 3 的索引分别为 0, 1
        graph.removeEdge(0, 1);
        System.out.println("\n删除边 1-3 后，图为");
        graph.print();

        /* 添加顶点 */
        graph.addVertex(6);
        System.out.println("\n添加顶点 6 后，图为");
        graph.print();

        /* 删除顶点 */
        // 顶点 3 的索引为 1
        graph.removeVertex(1);
        System.out.println("\n删除顶点 3 后，图为");
        graph.print();
    }
}
