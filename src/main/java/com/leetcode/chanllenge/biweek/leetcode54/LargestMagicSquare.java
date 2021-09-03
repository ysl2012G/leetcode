package com.leetcode.chanllenge.biweek.leetcode54;

public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        final int BORDER = grid.length;

        int max = 1;
        for (int len = 2; len <= BORDER; ++len) {

            for (int row = 0; row <= BORDER - len; ++row) {
                final int[] rowSum = new int[len];
                final int[] colSum = new int[len];
                final int[] diagSum = new int[2];

                for (int i = 0; i < len; ++i) {
                    for (int j = 0; j < len;  ++j) {
//                        rowSum += grid
                    }
                }

            }

        }
        return 0;
    }
}
