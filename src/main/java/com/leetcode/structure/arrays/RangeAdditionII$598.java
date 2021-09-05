package com.leetcode.structure.arrays;

public class RangeAdditionII$598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }

        final int max = ops.length;

        int maxRow = m;
        int maxCol = n;

        for (int[] op : ops) {
            maxRow = Math.min(maxRow, op[0]);
            maxCol = Math.min(maxCol, op[1]);
        }

        return maxRow * maxCol;
    }

}
