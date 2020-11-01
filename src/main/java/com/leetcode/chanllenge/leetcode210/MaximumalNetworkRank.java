package com.leetcode.chanllenge.leetcode210;

import java.util.HashSet;
import java.util.Set;

public class MaximumalNetworkRank {
    private static class Node {
        final int citiIndex;
        final Set<Integer> cities;
        int depth;

        public Node(int citiIndex) {
            this.citiIndex = citiIndex;
            depth = 0;
            this.cities = new HashSet<>();
        }

        public void addRoads(int index) {
            this.cities.add(index);
            ++depth;
        }

        public boolean isConnected(int index) {
            return cities.contains(index);
        }
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        final Node[] nodes = new Node[n];
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i);
        }

        for (int[] road: roads) {
            nodes[road[0]].addRoads(road[1]);
            nodes[road[1]].addRoads(road[0]);
        }



        int maxDepth = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                final Node firstNode = nodes[i];
                final Node secondNode = nodes[j];
                int localDepth = nodes[i].depth + nodes[j].depth;
                if (firstNode.isConnected(secondNode.citiIndex)) {
                    --localDepth;
                }
                maxDepth = Math.max(localDepth, maxDepth);
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5,6}, {5, 7}};
        new MaximumalNetworkRank().maximalNetworkRank(8, roads);
    }
}
