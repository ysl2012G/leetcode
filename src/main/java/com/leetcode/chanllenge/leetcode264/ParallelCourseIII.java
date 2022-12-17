package com.leetcode.chanllenge.leetcode264;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ParallelCourseIII {
    public int minimumTime(int n, int[][] relations, int[] time) {
        final int[] dists = new int[n];

        final int[] indegree = new int[n];

        final Map<Integer, List<Integer>> adj = new HashMap<>(n);
        for (int[] relation : relations) {
            final int prev = relation[0] - 1;
            final int next = relation[1] - 1;
            if (!adj.containsKey(prev)) {
                adj.put(prev, new ArrayList<>());
            }
            adj.get(prev).add(next);

            ++indegree[next];
        }

        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
                dists[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            final int prev = queue.poll();
            if (adj.containsKey(prev)) {
                for (int next : adj.get(prev)) {
                    dists[next] = Math.max(dists[next], dists[prev] + time[next]);
                    if (--indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        int ans = 0;
        for (int dist : dists) {
            ans = Math.max(dist, ans);
        }
        return ans;
    }
}
