package com.leetcode.algorithm.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix$54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;

        final List<Integer> res = new ArrayList<>();

        //  ind end loop

        final int totalElements = row * col;
        int loop = 0;
        while (res.size() < totalElements) {
            final int startColIndex = loop;
            final int endColIndex = col - loop - 1;
            final int startRowIndex = loop;
            final int endRowIndex = row - loop - 1;

            // upper boundary
            for (int j = startColIndex; j <= endColIndex; ++j) {
                res.add(matrix[startRowIndex][j]);
            }

            // right boundary
            for (int i = startRowIndex + 1; i <= endRowIndex; ++i) {
                res.add(matrix[i][endColIndex]);
            }

            // bottom boundary
            if (startRowIndex >= endRowIndex) {
                break;
            }
            for (int j = endColIndex - 1 ; j >= startColIndex; --j) {
                res.add(matrix[endRowIndex][j]);
            }

            // left boundary
            if (startColIndex >= endColIndex) {
                break;
            }
            for (int i = endRowIndex - 1; i > startRowIndex; --i) {
                res.add(matrix[i][startColIndex]);
            }

            ++loop;
        }

        return res;
    }


    @Test
    public void test() {
        final SpiralMatrix$54 solution = new SpiralMatrix$54();

        {
            final int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            final int[] expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};
            Assertions.assertArrayEquals(expected, solution.spiralOrder(matrix).stream().mapToInt(i -> i).toArray());
        }

        {
            final int[][] matrix = {{1, 2, 3, 4}};
            final int[] expected = {1, 2, 3, 4};
            Assertions.assertArrayEquals(expected, solution.spiralOrder(matrix).stream().mapToInt(i -> i).toArray());
        }


    }

}

