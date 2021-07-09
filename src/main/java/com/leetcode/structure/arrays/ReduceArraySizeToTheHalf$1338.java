package com.leetcode.structure.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReduceArraySizeToTheHalf$1338 {
    public int minSetSize(int[] arr) {
        final Map<Integer, Integer> cache = new HashMap<>();
        for (int num : arr) {
            cache.merge(num, 1, (oldVal, newVal) -> oldVal + 1);
        }
        final List<Integer> counters = new ArrayList<>(cache.values());
        counters.sort(Comparator.reverseOrder());

        final int halfLen = (arr.length + 1) / 2;
        int res = 0;
        int sum = 0;
        for (int counter : counters) {
            ++res;
            sum += counter;
            if (sum >= halfLen) {
                break;
            }
        }

        return res;
    }
}
