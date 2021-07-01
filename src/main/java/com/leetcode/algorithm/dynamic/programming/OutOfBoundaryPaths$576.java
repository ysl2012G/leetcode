package com.leetcode.algorithm.dynamic.programming;

public class OutOfBoundaryPaths$576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int memo[][] = new int[m][n];
        memo[startRow][startColumn] = 1;
        final int MODULE = (int)1e9 + 7;

        final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int res = 0;
        for (int k = 0; k < maxMove; ++k) {
            final int[][] auxi = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int[] direction : directions) {
                        final int row = i + direction[0];
                        final int col = j + direction[1];
                        if (isOutOfRange(m, n, row, col)) {
                            res = (res + memo[i][j]) % MODULE;
                        } else {
                            auxi[row][col] = (auxi[row][col] + memo[i][j]) % MODULE;
                        }
                    }
                }
            }
            memo = auxi;
        }

        return res;
    }

    private boolean isOutOfRange(int m, int n, int row, int col) {
        return row < 0 || row >= m || col < 0 || col >= n;
    }

}
