package com.leetcode.chanllenge.leetcode212;

public class PathWithMinEffort {
    public int minimumEffortPath2(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        final int memo[][] = new int[row][col];

        memo[0][0] = 0;
        // first row
        for (int j = 1; j < col; ++j) {
            final int effort = Math.abs(heights[0][j] - heights[0][j - 1]);
            memo[0][j] = Math.max(memo[0][j - 1], effort);
        }

        // first col
        for (int i = 1; i < row; ++i) {
            final int effort = Math.abs(heights[i][0] - heights[i - 1][0]);
            memo[i][0] = Math.max(memo[i - 1][0], effort);
        }

        for (int i = 1; i < row; ++i) {
            for (int j = i; j < col; ++j) {
                // from top
                int effort = Math.abs(heights[i][j] - heights[i - 1][j]);
                int minEffortFromTop = Math.max(memo[i - 1][j], effort);
                // from left
                effort = Math.abs(heights[i][j] - heights[i][j - 1]);
                int minEffortFromLeft = Math.max(memo[i][j - 1], effort);

                memo[i][j] = Math.min(minEffortFromTop, minEffortFromLeft);
            }
        }

        return memo[row - 1][col - 1];
    }

    private int[][] heigths;
    public int minimumEffortPath(int[][] heights) {
        this.heigths = heights;

    }

    public static void main(String[] args) {
        final int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        new PathWithMinEffort().minimumEffortPath(heights);
    }
}
