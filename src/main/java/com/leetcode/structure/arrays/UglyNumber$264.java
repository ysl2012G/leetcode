package com.leetcode.structure.arrays;

public class UglyNumber$264 {
    int nthUglyNumber(int n) {
        int[] res = new int[n];
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int mul1 = res[pos1] * 2;
            int mul2 = res[pos2] * 3;
            int mul3 = res[pos3] * 5;
            int value = Math.min(mul1, Math.min(mul2, mul3));
            if (value == mul1) { ++pos1; }
            if (value == mul2) { ++pos2; }
            if (value == mul3) { ++pos3; }
            res[i] = value;
        }
        return res[n - 1];
    }
}
