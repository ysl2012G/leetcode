package com.leetcode.chanllenge.leetcode216;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        final char[] chars = new char[n];
        Arrays.fill(chars, 'a');

        final int MOD = 25;
        final int divide = (k - n) / MOD;
        final int remainder = (k - n) % MOD;
        for (int i = 0; i < divide; ++i) {
            chars[n - 1 - i] += MOD;
        }
        chars[n - 1 - divide] += remainder;
        return new String(chars);
    }


}
