package com.leetcode.chanllenge.leetcode225;

import java.util.Arrays;

public class FindKthLargestXORValue {
    public int kthLargestValue(int[][] matrix, int k) {
        final int rowLen = matrix.length;
        final int colLen = matrix[0].length;

        final int[][] memo = new int[rowLen][colLen];
        memo[0][0] = matrix[0][0];
        for (int i = 1; i < rowLen; ++i) {
            memo[i][0] = memo[i - 1][0] ^ matrix[i][0];
        }
        for (int j = 1; j < colLen; ++j) {
            memo[0][j] = memo[0][j - 1] ^ matrix[0][j];
        }

        for (int i = 1; i < rowLen; ++i) {
            for (int j = 1; j < colLen; ++j) {
                memo[i][j] = memo[i - 1][j -1] ^ memo[i - 1][j] ^ memo[i][j - 1] ^ matrix[i][j];
            }
        }

        final int[] values = new int[rowLen * colLen];
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                values[i * colLen + j] = memo[i][j];
            }
        }

        Arrays.sort(values);

        return values[values.length - k];
    }


    public static void main(String[] args) {
        final int[][] matrix = {{5, 2}, {1, 6}};
        new FindKthLargestXORValue().kthLargestValue(matrix, 1);
    }
}
