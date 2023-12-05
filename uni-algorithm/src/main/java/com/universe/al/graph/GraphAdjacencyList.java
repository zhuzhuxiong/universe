package com.universe.al.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 邻接表
 *
 * @author l
 */
public class GraphAdjacencyList {

    /**
     * Vertex 顶点类，list 该顶点相连的顶点列表
     */
    Map<Vertex, List<Vertex>> adjList;

    public GraphAdjacencyList(Vertex[][] edges) {
        adjList = new HashMap<>();
        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    public int size() {
        return adjList.size();
    }

    public void addEdge(Vertex v1, Vertex v2) {
        if (!adjList.containsKey(v1) || !adjList.containsKey(v2) || v1 == v2) {
            throw new IllegalArgumentException();
        }
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    public void removeEdge(Vertex v1, Vertex v2) {
        if (!adjList.containsKey(v1) || !adjList.containsKey(v2) || v1 == v2) {
            throw new IllegalArgumentException();
        }
        adjList.get(v1).remove(v2);
        adjList.get(v2).remove(v1);
    }

    public void addVertex(Vertex ver) {
        if (adjList.containsKey(ver)) {
            return;
        }
        adjList.put(ver, new ArrayList<>());
    }

    public void removeVertex(Vertex ver) {
        if (!adjList.containsKey(ver)) {
            throw new IllegalArgumentException();
        }
        adjList.remove(ver);
        for (List<Vertex> list : adjList.values()) {
            list.remove(ver);
        }
    }

    public void print() {
        System.out.println("邻接表：=");
        for (Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (Vertex vertex : entry.getValue()) {
                tmp.add(vertex.val);
            }
            System.out.println(entry.getKey().val + ":" + tmp + ",");
        }
    }

}
