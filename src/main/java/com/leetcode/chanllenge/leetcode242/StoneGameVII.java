package com.leetcode.chanllenge.leetcode242;

public class StoneGameVII {
    public int stoneGameVIII(int[] stones) {
        final int LEN = stones.length;
        final int[] sum = new int[LEN];
        sum[0] = stones[0];
        for (int i = 1; i < LEN; ++i) {
            sum[i] += sum[i - 1] + stones[i];
        }

        final int[] memo = new int[LEN];
        memo[LEN - 1] = sum[LEN - 1];
        for (int i = LEN - 2; i >= 0; --i) {
            memo[i] = Math.max(sum[i] - memo[i + 1], memo[i + 1]);
        }

        return memo[1];
    }
}
