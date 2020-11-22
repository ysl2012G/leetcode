package com.leetcode.chanllenge.biweek.leetcode39;

public class MinDeletions2MakeStringBalanced {
    // dp
    public int minimumDeletions(String s) {
        final int len = s.length();
        final int[] memo = new int[len + 1];
        memo[0] = 0;
        int bCount = 0;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == 'a') {
                memo[i + 1] = Math.min(memo[i] + 1, bCount);
            } else {
                memo[i + 1] = memo[i];
                ++bCount;
            }
        }
        return memo[len];

    }

}
