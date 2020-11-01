package com.leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathFromSrouceToTaret$797 {
    private boolean[] isVisited;
    private List<List<Integer>> res;
    private int nodes;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.nodes = graph.length;
        isVisited = new boolean[nodes];
        res = new ArrayList<>();
         dfs(graph, new LinkedList<>(), 0);
        return res;
    }

    private void dfs(int[][] graph, LinkedList<Integer> path, int index) {
        if (index == nodes - 1) {
            List<Integer> fullPath = new ArrayList<>(path);
            fullPath.add(index);
            res.add(fullPath);
            return;
        }
        path.addLast(index);
        isVisited[index] = true;

        for (int adj: graph[index]) {
            if (!isVisited[adj]) {
                dfs(graph, path, adj);
            }
        }
        path.removeLast();
        isVisited[index] = false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        new AllPathFromSrouceToTaret$797().allPathsSourceTarget(graph);

    }
}
