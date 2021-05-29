package com.leetcode.chanllenge.leetcode232;

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        final Map<Integer, Integer> cache = new HashMap<>();
        for (int[] edge : edges) {
            final int node1 = edge[0];
            final int node2 = edge[1];

            cache.merge(node1, 1, (oldVal, newVal) -> oldVal + 1);
            cache.merge(node2, 1, (oldVal, newVal) -> oldVal + 1);
        }

        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getValue() == edges.length) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
