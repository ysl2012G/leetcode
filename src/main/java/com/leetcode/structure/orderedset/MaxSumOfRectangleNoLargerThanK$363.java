package com.leetcode.structure.orderedset;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK$363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int ROW_LEN = matrix.length;
        final int COL_LEN = matrix[0].length;

        final int[] rowSum = new int[COL_LEN];

        int result = Integer.MIN_VALUE;
        final TreeSet<Integer> sortedSum = new TreeSet();
        int currentSum = 0;
        for (int i = 0; i < ROW_LEN; ++i) {
            Arrays.fill(rowSum, 0);;

            for (int row = i; row < ROW_LEN; row ++) {
                for (int col = 0; col < COL_LEN; ++col) {
                    rowSum[col] += matrix[row][col];
                }

                // update result
                currentSum = 0;
                sortedSum.clear();
                sortedSum.add(0);
                for (int num : rowSum) {
                    currentSum += num;

                    Integer previousSum = sortedSum.ceiling(currentSum - k);
                    if (previousSum != null) {
                        result = Math.max(result, currentSum - previousSum);
                    }
                    sortedSum.add(currentSum);
                }

                if (result == k) {
                    return k;
                }
            }
        }

        return result;
    }

}
