package com.leetcode.algorithm.dynamic.programming;

public class MaximalSqure$221 {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row][col];
		int res = 0;
		for (int i = 0; i < row; i++) {
			dp[i][0] = matrix[i][0] - '0';
			res = Math.max(res, dp[i][0]);
		}
		for (int j = 0; j < col; j++) {
			dp[0][j] = matrix[0][j] - '0';
			res = Math.max(res, dp[0][j]);
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res * res;
	}
}
