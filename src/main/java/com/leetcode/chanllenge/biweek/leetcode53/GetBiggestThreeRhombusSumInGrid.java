package com.leetcode.chanllenge.biweek.leetcode53;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GetBiggestThreeRhombusSumInGrid {
    public int[] getBiggestThree(int[][] grid) {
        final int row = grid.length;
        final int col = grid[0].length;

        final Set<Integer> totalSum = new HashSet<>();
        final PriorityQueue<Integer> bigSum = new PriorityQueue<>(3, Comparator.reverseOrder());

        final int maxStep = (Math.min(row, col) - 1) / 2;

        for (int step = 0; step <= maxStep; ++step) {
            for (int i = 0; i < row - 2 * step; ++i) {
                for (int j = step; j < col - step; ++j) {
                    // count sum;
                    final int rhombusSum = getRhombusSum(grid, i, j, step);
                    if (totalSum.add(rhombusSum)) {
                        bigSum.add(rhombusSum);
                    }

                }
            }
        }

        if (bigSum.size() <= 3) {
            return bigSum.stream().mapToInt(i -> i).toArray();
        }

        final int[] res = new int[3];
        for (int i = 0; i < 3; ++i) {
            res[i] = bigSum.poll();
        }
        return res;
    }

    private int getRhombusSum(int[][] grid, int rowIndex, int colIndex, int step) {
        int sum = grid[rowIndex][colIndex];
        if (step != 0){
            sum += grid[rowIndex + step][colIndex - step];
            sum += grid[rowIndex + step][colIndex + step];
            sum += grid[rowIndex + 2 * step][colIndex];
        }
        for (int i = 1; i < step; ++i) {
            sum += grid[rowIndex + i][colIndex - i];
            sum += grid[rowIndex + i][colIndex + i];
            sum += grid[rowIndex + 2 * step - i][colIndex - i];
            sum += grid[rowIndex + 2 * step - i][colIndex + i];
        }

        return sum;
    }

    public static void main(String[] args) {
        final int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new GetBiggestThreeRhombusSumInGrid().getBiggestThree(grid);
    }
}
