package com.universe.al.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author l
 */
public class GraphAdjListBFS {

    public List<Vertex> adjListBFS(GraphAdjacencyList graph, Vertex startVer) {
        /**顶点 列表 返回结果*/
        ArrayList<Vertex> res = new ArrayList<>();

        /** 已访问的顶点set，用于滤重*/
        HashSet<Vertex> visited = new HashSet<>();
        visited.add(startVer);

        /**bfs 队列*/
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(startVer);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            res.add(vertex);

            for (Vertex v1 : graph.adjList.get(vertex)) {
                if (visited.contains(v1)) {
                    continue;
                }
                queue.offer(v1);
                visited.add(v1);
            }
        }
        return res;
    }

}
