package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;

public class PartitionEqualSubsetSum$416 {
    public boolean canPartition(int[] nums) {
        final int len = nums.length;
        final int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        final int target = sum / 2;
        final boolean[] memo = new boolean[target + 1];
        memo[0] = true;

        for (int num : nums) {
            for (int i = target; i >= 0; --i) {
                if (i >= num) {
                    memo[i] = memo[i] || memo[i - num];
                }
            }
        }
        return memo[target];
    }
}
