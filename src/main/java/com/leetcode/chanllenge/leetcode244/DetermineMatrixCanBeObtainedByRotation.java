package com.leetcode.chanllenge.leetcode244;

public class DetermineMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        if (isEquals(mat, target)) {
            return true;
        }

        for (int i = 1; i <= 3; ++i) {
            mat = rotate(mat);
            if (isEquals(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private int[][] rotate(int[][] mat) {
        final int LEN = mat.length;
        final int[][] rotate = new int[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; ++j) {
                rotate[j][LEN - 1 - i] = mat[i][j];
            }
        }
        return rotate;
    }

    private boolean isEquals(int[][] mat, int[][] target) {
        final int LEN = mat.length;
        for (int i = 0; i < LEN; ++i) {
            for (int j = 0; j < LEN; ++j) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
