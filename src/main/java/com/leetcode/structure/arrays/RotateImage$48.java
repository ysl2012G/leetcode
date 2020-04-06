package com.leetcode.structure.arrays;

public class RotateImage$48 {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int len = matrix.length;
        int iteratorNum = len >> 1;
        for (int row = 0; row < iteratorNum; row++ ) {
            for (int col = row; col < len - 1 - row; col ++ ) {
                int currRow = row;
                int currCol = col;
                int prevVal = matrix[currRow][currCol];
                for (int i = 0; i < 4; i ++) {
                    int nextRow = currCol;
                    int nextCol = len - 1 - currRow ;
                    int tempVal = matrix[nextRow][nextCol];
                    matrix[nextRow][nextCol] = prevVal;
                    currRow = nextRow;
                    currCol = nextCol;
                    prevVal = tempVal;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        new RotateImage$48().rotate(matrix);
    }

}
