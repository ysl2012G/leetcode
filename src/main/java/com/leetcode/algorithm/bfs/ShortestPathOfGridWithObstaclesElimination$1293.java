package com.leetcode.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class ShortestPathOfGridWithObstaclesElimination$1293 {
    private static class Cell {
        private final int rowIndex;
        private final int colIndex;
        private final int eliminations;


        public Cell(int rowIndex, int colIndex, int eliminations) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
            this.eliminations = eliminations;
        }

    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        final int rowLen = grid.length;
        final int colLen = grid[0].length;

        if (rowLen == 1 && colLen == 1) {
            return 0;
        }

        final Queue<Cell> queue = new LinkedList<>();

        final boolean[][][] visited = new boolean[rowLen][colLen][k + 1];
        queue.add(new Cell(0, 0, 0));
        visited[0][0][0] = true;

        int step = 0;
        while (!queue.isEmpty()) {
            ++step;
            final int size = queue.size();
            for (int i = 0; i < size; ++i) {
                final Cell cell = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    final int nextRow = cell.rowIndex + direction[0];
                    final int nextCol = cell.colIndex + direction[1];
                    int nextEliminations = cell.eliminations;

                    final boolean validIndex = nextRow >= 0 && nextRow < rowLen && nextCol >= 0 && nextCol < colLen;
                    if (validIndex) {
                        if (nextRow == rowLen - 1 && nextCol == colLen - 1) {
                            return step;
                        }
                        if (grid[nextRow][nextCol] == 1) {
                            ++nextEliminations;
                        }
                        if (nextEliminations <= k && !visited[nextRow][nextCol][nextEliminations]) {
                            visited[nextRow][nextCol][nextEliminations] = true;
                            queue.add(new Cell(nextRow, nextCol, nextEliminations));
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        final ShortestPathOfGridWithObstaclesElimination$1293 solution = new ShortestPathOfGridWithObstaclesElimination$1293();
        final int[][] grid = {{0,0,0}, {1,1,0}, {0,0,0}, {0,1,1}, {0,0,0}};
        solution.shortestPath(grid, 1);
    }
}
