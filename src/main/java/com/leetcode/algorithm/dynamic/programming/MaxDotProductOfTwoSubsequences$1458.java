package com.leetcode.algorithm.dynamic.programming;

public class MaxDotProductOfTwoSubsequences$1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;
        final int[][] memo = new int[len1][len2];
        memo[0][0] = nums1[0]*nums2[0];
        for (int i = 1; i < len1; ++i ) {
            memo[i][0] = Math.max(memo[i - 1][0] , nums1[i] * nums2[0]);
        }
        for (int j = 1; j < len2; ++j) {
            memo[0][j] = Math.max(memo[0][j - 1], nums1[0] * nums2[j]);
        }
        for (int i = 1; i < len1; ++i) {
            for (int j = 1; j < len2; ++j) {
                memo[i][j] = nums1[i] * nums2[j];
                if (memo[i - 1][j - 1] > 0) {
                    memo[i][j] += memo[i - 1][j - 1];
                }
                memo[i][j] = Math.max(memo[i][j - 1], memo[i][j]);
                memo[i][j] = Math.max(memo[i - 1][j], memo[i][j]);
            }
        }

        return memo[len1 - 1][len2 - 1];
    }
}
