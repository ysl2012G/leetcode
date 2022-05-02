package com.leetcode.algorithm.dynamic.programming;

import java.util.HashSet;
import java.util.Set;

public class LargestPlusSign$764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        final Set<Integer> mineIndex = new HashSet<>();
        for (int[] mine : mines) {
            mineIndex.add((mine[0] * n + mine[1]));
        }

        final int[][] memo = new int[n][n];
        int res = 0;

        for (int row = 0; row < n; ++row) {
            // left
            int count = 0;
            for (int col = 0; col < n; ++col) {
                count = mineIndex.contains(row * n + col) ? 0 : 1 + count;
                memo[row][col] = count;
            }

            // right
            count = 0;
            for (int col = n - 1; col >= 0; --col) {
                count = mineIndex.contains(row * n + col) ? 0 : 1 + count;
                memo[row][col] = Math.min(memo[row][col], count);
            }
        }

        for (int col = 0; col < n; ++col) {
            // top
            int count = 0;
            for (int row = 0; row < n; ++row) {
                count = mineIndex.contains(row * n + col) ? 0 : 1 + count;
                memo[row][col] = Math.min(memo[row][col], count);
            }

            // botoom
            count = 0;
            for (int row = n - 1; row >= 0; --row) {
                count = mineIndex.contains(row * n + col) ? 0 : 1 + count;
                memo[row][col] = Math.min(memo[row][col], count);
                res = Math.max(res, memo[row][col]);
            }
        }

        return res;
    }
}
