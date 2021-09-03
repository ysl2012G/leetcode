package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;

public class StoneGameIII$1406 {
    public String stoneGameIII(int[] stoneValue) {
        final int len = stoneValue.length;
        final int[] sums = new int[len];
        System.arraycopy(stoneValue, 0, sums, 0, len);
        for (int i = len - 2; i >=0; --i) {
            sums[i] += sums[i + 1];
        }

        int[] memo = new int[len + 1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        memo[len] = 0;
        memo[len - 1] = sums[len - 1];

        for (int i = len - 2; i >= 0; --i) {
            for (int offset = 1; offset <= 3 && i + offset <= len; ++offset) {
                memo[i] = Math.max(memo[i], sums[i] - memo[i + offset]);
            }
        }

        final int alice = memo[0];
        final int bob = sums[0] - memo[0];

        if (alice > bob) {
            return "Alice";
        } else if (alice < bob) {
            return "Bob";
        } else {
            return "Tie";
        }
    }


    public static void main(String[] args) {
        final int[] stoneValues = {-1, -2, -3};
        new StoneGameIII$1406().stoneGameIII(stoneValues);
    }
}
