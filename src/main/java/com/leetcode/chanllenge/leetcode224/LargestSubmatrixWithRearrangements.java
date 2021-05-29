package com.leetcode.chanllenge.leetcode224;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        final int rowLen = matrix.length;
        final int colLen = matrix[0].length;
        final int[] aux = new int[colLen];

        int max = 0;
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                aux[j] = matrix[i][j] > 0 ? ++aux[j] : 0;
            }
            final int[] temp = new int[colLen];
            System.arraycopy(aux, 0, temp, 0, colLen);
            Arrays.sort(temp);
            for (int k = 0; k < colLen; ++k) {
                if (temp[k] == 0 ) {
                    continue;
                }
                max = Math.max(max, temp[k] * (colLen - k));
            }
        }
        return max;
    }
}
