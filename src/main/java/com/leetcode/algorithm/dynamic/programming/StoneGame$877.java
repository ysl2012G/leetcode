package com.leetcode.algorithm.dynamic.programming;

public class StoneGame$877 {
    public boolean stoneGame(int[] piles) {
        final int len = piles.length;
        final int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; ++i ) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }

        final int[][] memo = new int[len][len];

        for (int i = 0; i < len; ++ i) {
            memo[i][i] = piles[i];
        }

        for (int step = 1; step < len; ++step) {
            for (int i = 0; i < len; ++ i) {
                if (i + step >= len) {
                    break;
                }
                final int totalSum = prefixSum[i + step + 1] - prefixSum[i];
                memo[i][i + step] = totalSum - Math.min(memo[i][i + step - 1], memo[i + 1][i + step]);
            }
        }

        return memo[0][len - 1] > memo[1][len - 1] || memo[0][len - 1] > memo[0][len - 2];
    }
}
