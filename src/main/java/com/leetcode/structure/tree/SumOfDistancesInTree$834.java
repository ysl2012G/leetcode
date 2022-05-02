package com.leetcode.structure.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfDistancesInTree$834 {
    private int[] relatedNodes;
    private int[] distances;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.relatedNodes = new int[n];
        this.distances = new int[n];

        final List<Set<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(tree, 0, -1);
        updateDistances(tree, 0, -1);
        return distances;
    }

    private void dfs(List<Set<Integer>> tree, int rootIndex, int preIndex) {
        for (int index : tree.get(rootIndex)) {
            if (index == preIndex) {
                continue;
            }
            dfs(tree, index, rootIndex);
            relatedNodes[rootIndex] += relatedNodes[index];
            distances[rootIndex] += distances[index] + relatedNodes[index];
        }
        ++relatedNodes[rootIndex];
    }

    private void updateDistances(List<Set<Integer>> tree, int rootIndex, int preIndex) {
        for (int index : tree.get(rootIndex)) {
            if (index == preIndex) {
                continue;
            }
            distances[index] = distances[rootIndex] - relatedNodes[index] + relatedNodes.length - relatedNodes[index];
            updateDistances(tree, index, rootIndex);
        }
    }
}
