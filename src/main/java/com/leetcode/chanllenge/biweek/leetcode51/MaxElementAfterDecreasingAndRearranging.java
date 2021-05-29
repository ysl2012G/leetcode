package com.leetcode.chanllenge.biweek.leetcode51;

import java.util.Arrays;

public class MaxElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        final int LEN = arr.length;
        Arrays.sort(arr);
        int res = 1;
        arr[0] = 1;
        for (int i = 1; i < LEN; ++i) {
            if (arr[i] > arr[i - 1]) {
                arr[i] = ++res;
            }
        }
        return res;
    }
}
