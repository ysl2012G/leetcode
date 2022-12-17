package com.leetcode.structure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class CountSubtreesWithMaxDistanceBetweenCities$1617 {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final int first = edge[0] - 1;
            final int second = edge[1] - 1;

            if (!graph.containsKey(first)) {
                graph.put(first, new ArrayList<>());
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new ArrayList<>());
            }
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        final int[] res = new int[n - 1];
        for (int mask = 1; mask < (1 << n); ++mask) {
            final int maxDistance = maxDistance(mask, graph, n);
            if (maxDistance > 0) {
                ++res[maxDistance - 1];
            }
        }
        return res;
    }

    private int maxDistance(int mask, Map<Integer, List<Integer>> graph, int n) {
        int startNode = 0;
        for (int i = 0; i < n; ++i) {
            if (((mask >> i) & 1) != 0) {
                startNode = i;
                break;
            }
        }

        final Queue<Integer> queue = new LinkedList<>();
        int farthestNode = startNode;
        int visited = 1 << startNode;
        queue.add(startNode);
		while (!queue.isEmpty()) {
			final int node = queue.poll();
			for (int adj : graph.get(node)) {
				final boolean inSubtree = ((mask >> adj) & 1) != 0;
				final boolean notVisited = ((visited >> adj) & 1) == 0;
				if (inSubtree && notVisited) {
					farthestNode = adj;
					queue.add(adj);
					visited |= 1 << adj;
				}
			}
		}

        if (farthestNode == startNode || visited != mask) {
            return 0;
        }

        // second bfs
        visited = 1 << farthestNode;
        int depth = -1;
        queue.add(farthestNode);
        while (!queue.isEmpty()) {
            ++depth;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                final int node = queue.poll();
                for (int adj : graph.get(node)) {
                    final boolean inSubtree = ((mask >> adj) & 1) != 0;
                    final boolean notVisited = ((visited >> adj) & 1) == 0;
                    if (inSubtree && notVisited) {
                        queue.add(adj);
                        visited |= 1 << adj;
                    }
                }
            }
        }
        return depth;
    }

    @Test
    public void test() {
        final int n = 4;
        final int[][] edges = {{1, 2}, {2, 3}, {2, 4}};
        final CountSubtreesWithMaxDistanceBetweenCities$1617 solution = new CountSubtreesWithMaxDistanceBetweenCities$1617();
        solution.countSubgraphsForEachDiameter(n , edges);
    }



}
