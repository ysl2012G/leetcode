package com.leetcode.chanllenge.leetcode263;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondMinTime2ReachDestination {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        final Map<Integer, List<Integer>> adjs = new HashMap<>();
        for (int[] edge: edges) {
            adjs.computeIfAbsent(edge[0] - 1, ArrayList::new).add(edge[1] - 1);
            adjs.computeIfAbsent(edge[1] - 1, ArrayList::new).add(edge[0] - 1);
        }

        final int[] dist = new int[n];
        final int DEFAULT_VAL = 1_000_000_000;
        Arrays.fill(dist, DEFAULT_VAL);
        dist[n - 1] = 0;

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(n - 1);

        while (!queue.isEmpty()) {
            final int city = queue.poll();
            for (int adjCity : adjs.computeIfAbsent(city, ArrayList::new)) {
                if (dist[adjCity] == DEFAULT_VAL) {
                    dist[adjCity] = dist[city] + 1;
                    queue.add(adjCity);
                }
            }
        }

        if (dist[0] == DEFAULT_VAL) {
            return -1;
        }

        queue.add(0);
        boolean hasShorterPath = false;
        while (!queue.isEmpty()) {
            final int city = queue.poll();
            for (int adjCity : adjs.get(city)) {
                if (dist[adjCity] == DEFAULT_VAL) {
                    continue;
                }
                if (dist[adjCity] == dist[city]) {
                    hasShorterPath = true;
                    break;
                } else if (dist[adjCity] == dist[city] - 1) {
                    queue.add(adjCity);
                }
            }
            if (hasShorterPath) { break; }
        }

        final int len = hasShorterPath ? dist[0] + 1 : dist[0] + 2;

        int totalElapsedTime = 0;
        for (int i = 0; i < len; ++i) {
            final int factor = totalElapsedTime / change;
            if (factor % 2 == 1) {
                totalElapsedTime = (factor + 1) * change;
            }
            totalElapsedTime += time;
        }

        return totalElapsedTime;
    }

    @Test
    public void test() {
        final int[][] edges = {{1,2}, {1,3}, {1,4}, {3,4}, {4,5}};

        final SecondMinTime2ReachDestination solution = new SecondMinTime2ReachDestination();
        Assertions.assertEquals(13, solution.secondMinimum(5, edges, 3, 5));
    }


}
