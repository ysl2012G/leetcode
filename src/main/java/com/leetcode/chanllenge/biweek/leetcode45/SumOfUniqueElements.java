package com.leetcode.chanllenge.biweek.leetcode45;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        final Map<Integer, Integer> cache = new HashMap<>();
        for (int num : nums) {
            cache.merge(num, 1, (oldVal, newVal) -> oldVal + 1);
        }

        return cache.entrySet().stream().filter(x -> x.getValue() == 1).mapToInt(x -> x.getKey()).sum();

    }
}
