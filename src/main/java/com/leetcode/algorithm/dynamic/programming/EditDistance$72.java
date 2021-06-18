package com.leetcode.algorithm.dynamic.programming;

public class EditDistance$72 {
    public int minDistance(String word1, String word2) {
        final int len1 = word1.length();
        final int len2 = word2.length();

        final int[][] memo = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; ++i) {
            memo[i][0] = i;
        }
        for (int j = 1; j <= len2; ++j) {
            memo[0][j] = j;
        }

        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    final int insertCount = memo[i][j - 1];
                    final int replaceCount = memo[i - 1][j - 1];
                    final int deleteCount = memo[i - 1][j];

                    memo[i][j] = Math.min(deleteCount, Math.min(insertCount, replaceCount)) + 1;
                }
            }
        }

        return memo[len1][len2];

    }
}
