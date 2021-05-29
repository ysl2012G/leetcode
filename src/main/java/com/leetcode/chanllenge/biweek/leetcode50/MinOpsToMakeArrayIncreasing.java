package com.leetcode.chanllenge.biweek.leetcode50;

public class MinOpsToMakeArrayIncreasing {
    public int minOperations(int[] nums) {
        int ops = 0;
        int previous = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (previous >= nums[i]) {
                ops += previous + 1 - nums[i];
                ++previous;
            } else {
                previous = nums[i];
            }
        }
        return ops;
    }
}
