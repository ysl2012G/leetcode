package com.leetcode.chanllenge.leetcode266;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumPathQualityOfGraph {
    private static class ConnectedNode {
        final int endNode;
        final int cost;
        public ConnectedNode(int endNode, int cost) {
            this.endNode = endNode;
            this.cost = cost;
        }
    }


    private int[] values;
    private Map<Integer, List<ConnectedNode>> adjs;
    private int ans;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        this.adjs = new HashMap<>();

        for (int[] edge : edges) {
            final int first = edge[0];
            final int second = edge[1];
            final int cost = edge[2];

            List<ConnectedNode> firstConnected = adjs.get(first);
            if (firstConnected == null) {
                firstConnected = new ArrayList<>();
                adjs.put(first, firstConnected);
            }

            List<ConnectedNode> secondConnected = adjs.get(second);
            if (secondConnected == null) {
                secondConnected = new ArrayList<>();
                adjs.put(second, secondConnected);
            }

            firstConnected.add(new ConnectedNode(second, cost));
            secondConnected.add(new ConnectedNode(first, cost));

        }

        this.ans = 0;
        final boolean[] visited = new boolean[values.length];
        visited[0] = true;
        dfs(0, visited, values[0], maxTime);
        return ans;
    }

    private void dfs(int curr, boolean[] visited, int gain, int remainTime) {
        if (remainTime < 0) {
            return;
        }
        if (curr == 0) {
            ans = Math.max(gain, ans);
        }

        final List<ConnectedNode> connectedNodes = adjs.get(curr);
        if (connectedNodes == null) {
            return;
        }

        for (ConnectedNode adj : connectedNodes) {
            final int nextNode = adj.endNode;
            final int cost = adj.cost;
            final boolean hasVisited = visited[nextNode];

            final int currGain = hasVisited ? gain : gain + values[nextNode];
            visited[nextNode] = true;
            dfs(adj.endNode, visited, currGain, remainTime - cost);
            visited[nextNode] = hasVisited;
        }
    }
}
