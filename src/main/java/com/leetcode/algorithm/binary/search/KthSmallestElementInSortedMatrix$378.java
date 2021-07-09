package com.leetcode.algorithm.binary.search;

public class KthSmallestElementInSortedMatrix$378 {
    public int kthSmallest(int[][] matrix, int k) {
        final int LEN = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[LEN - 1][LEN - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int counter = getNoGreaterElements(matrix, mid) ;
            if (counter < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        } 
        return lo;
    }


    private int getNoGreaterElements(int[][] matrix, int target) {
        final int LEN = matrix.length;
        int i = LEN - 1;
        int j = 0;
        int counter = 0;
        while (i >= 0 && j < LEN) {
            if (matrix[i][j] <= target) {
                counter += i + 1;
                ++j;
            } else {
                --i;
            }
        }
        return counter;
    }
}
