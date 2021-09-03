package com.leetcode.algorithm.dynamic.programming;

public class DecodeWays$91 {
    public int numDecodings(String s) {

        int prevVal = s.charAt(0) - '0';
        int first = 1;
        int second = prevVal == 0 ? 0 : 1;

        for (int i = 1; i < s.length(); ++i) {
            final int currVal = s.charAt(i) - '0';

            int curr = 0;
            if (currVal >= 1 && currVal <= 9) {
                curr += second;
            }
            int twoDigits = prevVal * 10 + currVal;
            if (twoDigits >= 10 && twoDigits <= 26) {
                curr += first;
            }

            first = second;
            second = curr;
        }
        return second;
    }


    public static void main(String[] args) {
        new DecodeWays$91().numDecodings("2101");
    }
}
