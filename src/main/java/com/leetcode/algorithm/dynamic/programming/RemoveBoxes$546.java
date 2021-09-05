package com.leetcode.algorithm.dynamic.programming;

public class RemoveBoxes$546 {
    public int removeBoxes(int[] boxes) {
        final int len = boxes.length;

        int[][][] memo = new int[len][len][len];
        return helper(boxes, 0, len - 1, 0, memo);
    }

    private int helper(int[] boxes, int left, int right, int equalLeftNumber, int[][][] memo) {
        if (left > right) {
            return 0;
        }
        if (memo[left][right][equalLeftNumber] > 0) {
            return memo[left][right][equalLeftNumber];
        }

        int i = left;
        int j = right;
        int k = equalLeftNumber;
        for (; i < j && boxes[i + 1] == boxes[i]; ++i) {
            ++k;
        }
        int res = (k + 1) * (k + 1) + helper(boxes, i + 1, right, 0, memo);

        for (int m = i + 1; m <=j; ++m) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, helper(boxes, i + 1, m - 1, 0, memo) + helper(boxes, m, right, k + 1, memo));
            }
        }
        memo[left][right][equalLeftNumber] = res;

        return res;
    }
}
