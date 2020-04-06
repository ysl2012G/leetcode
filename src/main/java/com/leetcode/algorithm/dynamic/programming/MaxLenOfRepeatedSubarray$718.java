package com.leetcode.algorithm.dynamic.programming;

public class MaxLenOfRepeatedSubarray$718 {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int aLen = A.length;
        int bLen = B.length;
        int[][] memo = new int[aLen + 1][bLen + 1];
        int res = 0;
        for (int i = 1; i <= aLen; i++ ) {
            for (int j = 1; j <= bLen; j++) {
                if (A[i - 1] == B[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    res = Math.max(res, memo[i][j]);
                } else {
                    memo[i][j] = 0;
                }

            }
        }

        return res;

    }
}
