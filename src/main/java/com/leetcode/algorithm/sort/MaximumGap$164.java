package com.leetcode.algorithm.sort;

import java.util.Arrays;

public class MaximumGap$164 {
    public int maximumGap(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        final int len = nums.length;
        final int size = (max - min) / len + 1;
        final int bucketSize = (max - min) / size + 1;

        final int[] min_buckets = new int[bucketSize];
        Arrays.fill(min_buckets, Integer.MAX_VALUE);
        final int[] max_buckets = new int[bucketSize];
        Arrays.fill(max_buckets, Integer.MIN_VALUE);

        for (int num : nums) {
            final int bucketIndex = (num - min) / size;
            min_buckets[bucketIndex] = Math.min(num, min_buckets[bucketIndex]);
            max_buckets[bucketIndex] = Math.max(num, max_buckets[bucketIndex]);
        }

        int maxGap = 0, previousIndex = 0;
        for (int i = 0; i < bucketSize; ++i) {
            if (max_buckets[i] == Integer.MIN_VALUE && min_buckets[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, min_buckets[i] - max_buckets[previousIndex]);
            previousIndex = i;
        }

        return maxGap;
    }
}
