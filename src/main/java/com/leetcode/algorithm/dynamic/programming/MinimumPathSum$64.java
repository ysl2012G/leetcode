package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;

public class MinimumPathSum$64 {
	public int minPathSum(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int rowLen = grid.length;
		if (rowLen == 0) {
			return 0;
		}
		int colLen = grid[0].length;
		if (colLen == 0) {
			return 0;
		}
		int[][] dp = new int[rowLen][colLen];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < rowLen; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}
		for (int j = 1; j <colLen; j++) {
			dp[0][j] = grid[0][j] + dp[0][j - 1];
		}

		for (int i = 1; i < rowLen; i++) {
			for (int j = 1; j < colLen; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[rowLen - 1][colLen - 1];
	}

	public int minPathSum2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rowLen = grid.length;
        if (rowLen == 0) {
            return 0;
        }
        int colLen = grid[0].length;
        if (colLen == 0) {
            return 0;
        }
        int[] dp = new int[colLen];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colLen - 1];

    }
}
