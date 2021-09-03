package com.leetcode.structure.arrays;

import java.util.Arrays;

public class Matrix$542 {
    public int[][] updateMatrix(int[][] mat) {
        final int row = mat.length;
        final int col = mat[0].length;


        final int[][] dist = new int[row][col];
        for (int[] rowDist : dist) {
            Arrays.fill(rowDist, Integer.MAX_VALUE - 10000);
        }


        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                final int val = mat[i][j];

                if (val > 0) {
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                } else {
                    dist[i][j] = 0;
                }
            }
        }

        for (int i = row - 1; i >= 0; --i) {
            for (int j = col - 1; j >= 0; --j) {
                final int val = mat[i][j];

                if (val > 0) {
                    if (i + 1 < row) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j + 1 < col) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }else {
                    dist[i][j] = 0;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
		final int[][] mat = {{0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 1}, {1, 1, 1, 1, 0}, {1, 0, 0, 1, 0}};

        new Matrix$542().updateMatrix(mat);
    }
}
