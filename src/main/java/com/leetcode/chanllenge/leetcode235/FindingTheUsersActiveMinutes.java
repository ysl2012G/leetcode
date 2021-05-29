package com.leetcode.chanllenge.leetcode235;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        final int[] res = new int[k];

        final Map<Integer, Set<Integer>> cache = new HashMap<>();

        for (int[] log : logs) {
            final  Set<Integer> counter = cache.computeIfAbsent(log[0], t -> new HashSet<>());
            counter.add(log[1]);
        }

        for (Set<Integer> counter : cache.values()) {
            ++res[counter.size() - 1];
        }
        return res;
    }
}
