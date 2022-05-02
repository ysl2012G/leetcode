package com.leetcode.algorithm.dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestTurbulentSubarray$978 {
    public int maxTurbulenceSize(int[] arr) {
        final int len = arr.length;

        int res = 1;
        int endAtLargeElement = 1;
        int endAtSmallerElement = 1;
        for (int i = 1; i < len; ++i) {
            int cmp = Integer.compare(arr[i], arr[i - 1]);
            if (cmp > 0) {
                endAtLargeElement = endAtSmallerElement + 1;
                endAtSmallerElement = 1;
            } else if (cmp < 0) {
                endAtSmallerElement = endAtLargeElement + 1;
                endAtLargeElement = 1;
            } else {
                endAtLargeElement = 1;
                endAtSmallerElement = 1;
            }

            res = Math.max(res, Math.max(endAtLargeElement, endAtSmallerElement));
        }

        return res;
    }

    @Test
    public void test() {
        final LongestTurbulentSubarray$978 solution = new LongestTurbulentSubarray$978();

        Assertions.assertEquals(5, solution.maxTurbulenceSize(new int[] {9,4,2,10,7,8,8,1,9}));
    }


}
