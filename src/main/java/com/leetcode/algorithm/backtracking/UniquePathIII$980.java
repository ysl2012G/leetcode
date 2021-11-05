package com.leetcode.algorithm.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniquePathIII$980 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int targetPath;
    private int endIndex;
    private int[][] grid;
    private int rowLen;
    private int colLen;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.rowLen = grid.length;
        this.colLen = grid[0].length;

        int startIndex = 0;
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                final int index = i * colLen + j;
                if (grid[i][j] == 1) {
                    startIndex = index;
                    this.targetPath |= 1 << index;
                } else if (grid[i][j] == 0) {
                    this.targetPath |= 1 << index;
                } else if (grid[i][j] == 2) {
                    this.endIndex = index;
                }
            }
        }

        return backtrack(startIndex, 0);
    }

    private int backtrack(int index, int currPath) {
        if (index == endIndex) {
            return currPath == targetPath ? 1 : 0;
        }

        if ((currPath & (1 << index)) != 0) {
            return 0;
        }

        currPath |= 1 << index;

        final int rowIndex = index / colLen;
        final int colIndex = index % colLen;

        int path = 0;
        for (int[] direction : DIRECTIONS) {
            final int nextRow = rowIndex + direction[0];
            final int nextCol = colIndex + direction[1];

            final boolean validCell = nextRow >= 0 && nextRow < rowLen && nextCol >= 0 && nextCol < colLen;
            if (validCell && grid[nextRow][nextCol] >= 0) {
                path += backtrack(nextRow * colLen + nextCol, currPath);
            }
        }
        return path;
    }

    @Test
    public void test() {
        final UniquePathIII$980 solution = new UniquePathIII$980();
        final int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};

        Assertions.assertEquals(2, solution.uniquePathsIII(grid));
    }

}
