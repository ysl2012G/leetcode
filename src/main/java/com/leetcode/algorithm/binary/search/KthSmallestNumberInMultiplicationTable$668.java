package com.leetcode.algorithm.binary.search;

public class KthSmallestNumberInMultiplicationTable$668 {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m * n + 1;
        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;
            if (efficientCount(mid, m, n) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int efficientCount(int val, int m, int n) {
        int count = 0;
        int row = m;
        int col = 1;
        while (row >= 1 && col <= n) {
            int prevCol = col;
            col = (val > n * row) ? n + 1 : (val / row + 1);
            count = (col - prevCol) * row;
            row = val / col;
        }

        return count;
    }

    private int count(int val, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; ++i) {
            count += Math.min(val / i, n);
        }
        return count;
    }
}
