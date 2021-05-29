package com.leetcode.chanllenge.leetcode219;

public class StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int stoneNumber = stones.length;
        final int[] preSum = new int[stoneNumber + 1];
        for (int i = 0; i < stoneNumber; ++i) {
            preSum[i + 1] = preSum[i] + stones[i];
        }

        int[][] memo = new int[stoneNumber][stoneNumber];

        for (int len = 2; len <= stoneNumber; ++len) {
            for (int left = 0; left + len - 1 < stoneNumber; ++ left) {
                int right = left + len - 1;
                final int leftScores = preSum[right + 1] - preSum[left + 1] - memo[left + 1][right];
                final int rightScores = preSum[right] - preSum[left] - memo[left][right - 1];
                memo[left][right] = Math.max(leftScores, rightScores);
            }
        }

        return memo[0][stoneNumber -1];

    }
}
