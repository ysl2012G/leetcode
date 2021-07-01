package com.leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes$815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) { return 0;}
        final Map<Integer, List<Integer>> stopBuses = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int stop : routes[i]) {
                final List<Integer> buses = stopBuses.computeIfAbsent(stop, k -> new ArrayList<>());
                buses.add(i);
            }
        }

        final Set<Integer> visited = new HashSet<>();
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int res = 0;
        while (!queue.isEmpty()) {
            ++res;
            for (int i = queue.size(); i > 0; --i) {
                final int currStop = queue.poll();
                final List<Integer> buses = stopBuses.get(currStop);
                if (buses == null) { continue; }
                for (int bus : buses) {
                    if (!visited.add(bus)) { continue; }
                    for (int stop : routes[bus]) {
                        if (stop == target) { return res; }
                        queue.add(stop);
                    }
                }
            }
        }

        return -1;
    }
}
