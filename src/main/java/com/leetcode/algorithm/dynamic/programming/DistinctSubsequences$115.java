package com.leetcode.algorithm.dynamic.programming;

public class DistinctSubsequences$115 {
    public int numDistinct(String s, String t) {
        final int sLen = s.length();
        final int tLen = t.length();

        final int[] memo = new int[tLen + 1];
        memo[0] = 1;

        for (int i = 1; i <= sLen; ++i) {
            for (int j = tLen; j > 0; --j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    memo[j] += memo[j - 1];
                }
            }
        }

        return memo[tLen];

//        for (int i = 0; i <= sLen; ++i) {
//            memo[i][0] = 1;
//        }

//        for (int i = 1; i <= sLen; ++i) {
//            for (int j = 1; j <= tLen; ++j) {
//                // not choose
//                memo[i][j] = memo[i - 1][j];
//                if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                    // choose
//                    memo[i][j] += memo[i - 1][j - 1];
//                }
//            }
//        }
//        return memo[sLen][tLen];
    }
}
