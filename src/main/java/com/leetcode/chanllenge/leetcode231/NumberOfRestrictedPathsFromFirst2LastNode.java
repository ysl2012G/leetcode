package com.leetcode.chanllenge.leetcode231;

import java.util.*;

public class NumberOfRestrictedPathsFromFirst2LastNode {

    private static class EdgeInfo {
        final int from;
        final int to;
        final int weight;

        public EdgeInfo(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    private static class Node {
        final int index;
        final int distance;
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }
    }


    public int countRestrictedPaths(int n, int[][] edges) {
        final Map<Integer, List<EdgeInfo>> graphs = new HashMap<>();

        for (int[] edge : edges) {
            final int first = edge[0];
            final int second = edge[1];
            final int weight = edge[2];

            graphs.computeIfAbsent(first, k -> new ArrayList<>()).add(new EdgeInfo(first, second, weight));
            graphs.computeIfAbsent(second, k -> new ArrayList<>()).add(new EdgeInfo(second, first, weight));
        }

        final int[] paths = getShortestPath(n, graphs);

        final int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(1, n, graphs, paths, memo);
    }

    private int[] getShortestPath(int n, Map<Integer, List<EdgeInfo>> graphs) {
        final int[] distTo = new int[n + 1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[n] = 0;


        final PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        queue.add(new Node(n, distTo[n]));

        while (!queue.isEmpty()) {
            final Node current = queue.poll();

            final int fromIndex = current.index;
            final List<EdgeInfo> adjEdges = graphs.get(fromIndex);
            for (EdgeInfo edgeInfo : adjEdges) {
                final int toIndex = edgeInfo.to;

                if (distTo[toIndex] > distTo[fromIndex] + edgeInfo.weight) {
                    distTo[toIndex] = distTo[fromIndex] + edgeInfo.weight;
                    queue.add(new Node(toIndex, distTo[toIndex]));
                }
            }
        }

        return distTo;
    }

    private int dfs(int from, int end, Map<Integer, List<EdgeInfo>> graphs, int[] distTo, int[] memo) {
        if (memo[from] != -1) {
            return memo[from];
        }
        if (from == end) {
            return 1;
        }
        int ans = 0;
        final int DIVIDEND = (int) (1e9 + 7);
        for (EdgeInfo edgeInfo : graphs.get(from)) {
            final int to = edgeInfo.to;
            if (distTo[from] > distTo[to]) {
                ans = (ans + dfs(to, end, graphs, distTo, memo)) % DIVIDEND;
            }
        }
        memo[from] = ans;
        return ans;
    }
}
