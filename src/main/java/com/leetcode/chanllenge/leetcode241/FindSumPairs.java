package com.leetcode.chanllenge.leetcode241;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    private Map<Integer, Integer> cache;
    private int[] nums1;
    private int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.cache = new HashMap<>();
        for (int num : nums2) {
            cache.merge(num, 1, (oldV, newV) -> oldV + 1);
        }
        this.nums1 = nums1;
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        final int previous = nums2[index];
        nums2[index] += val;
        cache.computeIfPresent(previous, (k, v) -> v - 1);
        cache.merge(previous + val, 1, (oldV, newV) -> oldV + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            count += cache.getOrDefault(tot - num, 0);
        }
        return count;
    }
}
