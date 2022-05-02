package com.leetcode.structure.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReachableNodesInSubdividedGraph$882 {
    private static class Node {
        private final int index;
        private int dist;

        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public int getDist() {
            return dist;
        }
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        final Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], edge[2]);
        }

        final PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDist));
        queue.add(new Node(0, 0));

        final Map<Integer, Integer> dists = new HashMap<>();
        dists.put(0, 0);

        final Map<Integer, Integer> used = new HashMap<>();

        int ans = 0;

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            final int index = node.index;
            final int dist = node.dist;

            if (node.dist > dists.getOrDefault(node.index, 0)) {
                continue;
            }

            // each node noly visited onces;
            ans ++;

            if (!graph.containsKey(index)) {
                continue;
            }

            for (int neigh : graph.get(index).keySet()) {
                final int subdivides = graph.get(index).get(neigh);
                int reachNodes = Math.min(subdivides, maxMoves - node.dist);
                used.put(index * n + neigh, reachNodes);

                final int neighDist = dist + subdivides + 1;
                if (neighDist < dists.getOrDefault(neigh, maxMoves + 1)) {
                    queue.add(new Node(neigh, neighDist));
                    dists.put(neigh, neighDist);
                }
            }
        }
        
        // 最后，更新ans值，edge中的subdivides,要么从两端都包括了，要么就没有包括
        for (int[] edge : edges) {
            ans += Math.min(edge[2], used.getOrDefault(edge[0] * n + edge[1], 0) + used.getOrDefault(edge[1] * n + edge[0], 0));
        }



        return ans;
    }
}
