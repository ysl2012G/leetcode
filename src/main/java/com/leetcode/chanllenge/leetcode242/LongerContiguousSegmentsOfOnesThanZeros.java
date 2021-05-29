package com.leetcode.chanllenge.leetcode242;

public class LongerContiguousSegmentsOfOnesThanZeros {
    public boolean checkZeroOnes(String s) {
        int ones = 0;
        int zeros = 0;
        int previous = s.charAt(0) - '0';
        int curr = 1;

        for (int i = 1; i < s.length(); ++i) {
            final int digit = s.charAt(i) - '0';
            if (digit != previous) {
                if (previous == 0) {
                    zeros = Math.max(zeros, curr);
                } else {
                    ones = Math.max(ones, curr);
                }
                previous = digit;
                curr = 1;
            } else {
                ++curr;
            }
        }

        if (previous == 0) {
            zeros = Math.max(zeros, curr);
        } else {
            ones = Math.max(ones, curr);
        }


        return ones > zeros;

    }
}
