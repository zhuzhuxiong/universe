package com.universe.al.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author l
 */
public class GraphAdjListDFS {

    public void dfs(GraphAdjacencyList graph, Set<Vertex> visited, List<Vertex> res, Vertex vertex) {
        res.add(vertex);
        visited.add(vertex);
        for (Vertex v : graph.adjList.get(vertex)) {
            if (visited.contains(v)){
                continue;
            }
            dfs(graph,visited,res,v);
        }
    }

    public List<Vertex> adjListDFS(GraphAdjacencyList graph, Vertex startVer) {
        ArrayList<Vertex> res = new ArrayList<>();
        HashSet<Vertex> visited = new HashSet<>();
        dfs(graph, visited, res, startVer);
        return res;
    }
}
