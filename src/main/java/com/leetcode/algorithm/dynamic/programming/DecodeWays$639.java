package com.leetcode.algorithm.dynamic.programming;

public class DecodeWays$639 {
    public int numDecodings(String s) {
        final int len = s.length();
        long first = 1;
        long second = 0;
        char prev = s.charAt(0);

        if (s.charAt(0) != '0') {
            second = prev == '*' ? 9 : first;
        }

        final int MOD = (int) 1e9 + 7;
        for (int i = 1; i < len; ++i) {
            final char ch = s.charAt(i);
            final boolean isAsterisk = ch == '*';
            long curr = 0;

            if (ch != '0') {
                curr = (isAsterisk) ? (second * 9) % MOD : second;
            }

            switch (prev) {
            case '1':
                curr += (isAsterisk) ? (first * 9) % MOD : first;
                break;
            case '2':
                if (isAsterisk) {
                    curr += (first * 6) % MOD;
                } else if (ch - '0' <= 6) {
                    curr += first;
                }
                break;
            case '*':
                if (isAsterisk) {
                    curr += (first * 15) % MOD;
                } else if (ch - '0' <= 6) {
                    curr += (first * 2) % MOD;
                } else {
                    curr += first;
                }
                break;
            default:
                break;
            }
            curr %= MOD;
            first = second;
            second = curr;
            prev = ch;
        }

        return (int) second;
    }
}
