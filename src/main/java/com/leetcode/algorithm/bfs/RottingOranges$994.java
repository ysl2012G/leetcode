package com.leetcode.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RottingOranges$994 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        final int rowLen = grid.length;
        final int colLen = grid[0].length;

        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(i * colLen + j);
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; ++i) {
                final int index = queue.poll();
                final int rowIndex = index / colLen;
                final int colIndex = index % colLen;

                for (int[] direction : DIRECTIONS) {
                    final int nextRow = rowIndex + direction[0];
                    final int nextCol = colIndex + direction[1];

                    final boolean validCell = nextRow >= 0 & nextRow < rowLen && nextCol >= 0 && nextCol < colLen;
                    if (validCell && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        queue.add(nextRow * colLen + nextCol);
                    }
                }
            }
			if (!queue.isEmpty()) {
				++minutes;
			}
        }

        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }

    @Test
    public void test() {
		final int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        final RottingOranges$994 solution = new RottingOranges$994();
        Assertions.assertEquals(4, solution.orangesRotting(grid));

    }

}
