package com.leetcode.chanllenge.leetcode226;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RestoreArrayFromAdjPairs {

    public int[] restoreArray(int[][] adjacentPairs) {
        final Map<Integer, Set<Integer>> elements = new HashMap<>();

        for (int i = 0; i < adjacentPairs.length; ++i) {
            final Set<Integer> adj1 = elements.computeIfAbsent(adjacentPairs[i][0], k -> new HashSet<>());
            adj1.add(adjacentPairs[i][1]);

            final Set<Integer> adj2 = elements.computeIfAbsent(adjacentPairs[i][1], k -> new HashSet<>());
            adj2.add(adjacentPairs[i][0]);
        }

        int start = 0;
        for (int element : elements.keySet()) {
            if (elements.get(element).size() == 1) {
                start = element;
                break;
            }
        }

        final int[] array = new int[adjacentPairs.length + 1];
        array[0] = start;

        for (int i = 1; i < array.length; ++i) {
            array[i] = elements.get(array[i - 1]).iterator().next();
            elements.get(array[i]).remove(array[i -1]);
        }

        return array;
    }

    public static void main(String[] args) {
        final int[][] pairs = {{2, 1}, {3, 4}, {2, 3}};
        new RestoreArrayFromAdjPairs().restoreArray(pairs);
    }
}
