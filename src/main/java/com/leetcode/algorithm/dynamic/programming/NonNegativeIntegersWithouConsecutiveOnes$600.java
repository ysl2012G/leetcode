package com.leetcode.algorithm.dynamic.programming;

public class NonNegativeIntegersWithouConsecutiveOnes$600 {
    public int findIntegers(int n) {
        final int[] memo = new int[32];
        memo[0] = 1;
        memo[1] = 2;
        for (int i = 2; i < 32; ++i) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        int sum = 0;
        int prev = 0;
        int bit = 31;
        while (bit >= 0) {
            if ((n & (1 << bit)) != 0) {
                sum += memo[bit];
                if (prev == 1) {
                    --sum;
                    break;
                }
                prev = 1;
            } else {
                prev = 0;
            }
            --bit;
        }

        return sum + 1;
    }
}
