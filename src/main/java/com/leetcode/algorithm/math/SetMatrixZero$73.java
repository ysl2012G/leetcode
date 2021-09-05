package com.leetcode.algorithm.math;

import java.util.Arrays;

public class SetMatrixZero$73 {
    public void setZeroes(int[][] matrix) {

        final int row = matrix.length;
        final int col = matrix[0].length;


        boolean setFirstCol = false;
        for (int i = 0; i < row; ++i) {
            if (matrix[i][0] == 0) {
                setFirstCol = true;
            }

            for (int j = 1; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            Arrays.fill(matrix[0], 0);
        }

        if (setFirstCol) {
            for (int i = 0; i < row; ++i) {
                matrix[i][0] = 0;
            }
        }


    }

    public static void main(String[] args) {
        final int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        new SetMatrixZero$73().setZeroes(matrix);
    }
}
