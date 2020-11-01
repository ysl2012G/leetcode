package com.leetcode.algorithm.dynamic.programming;

public class LongestCommonSubseq$1143 {
	public int longestCommonSubsequence(String text1, String text2) {
		int firstLen = text1.length();
		int secondLen = text2.length();
		int[][] dp = new int[firstLen + 1][secondLen + 1];

		for (int i = 0; i < firstLen; i++) {
			for (int j = 0; j < secondLen; j++) {
				dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
				}
			}
		}
		return dp[firstLen][secondLen];
	}

    public static void main(String[] args) {
        new LongestCommonSubseq$1143().longestCommonSubsequence("abcde", "ace");
    }
}
