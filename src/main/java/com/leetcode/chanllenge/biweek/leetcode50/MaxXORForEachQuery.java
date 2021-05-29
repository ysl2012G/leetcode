package com.leetcode.chanllenge.biweek.leetcode50;

public class MaxXORForEachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        final int LEN = nums.length;
        final int[] res = new int[LEN];

        int xor = 0;
        for (int i = 0; i < LEN; ++i) {
            xor ^= nums[i];
        }

        final int max = (1 << maximumBit) - 1;
        for (int i = 0; i < LEN; ++i) {
            res[i] = max ^ xor;
            xor ^= nums[LEN - 1 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        final int[] nums = {0, 1, 1, 3};
        new MaxXORForEachQuery().getMaximumXor(nums, 2);
    }
}
