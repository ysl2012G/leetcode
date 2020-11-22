package com.leetcode.chanllenge.biweek.leetcode38;

public class CountSubstrThatDifferByOneCharacter {
    public int countSubstrings(String s, String t) {
        final int sLen = s.length();
        final int tLen = t.length();
        final int[][] dpl = new int[sLen + 1][tLen + 1];
        final int[][] dpr = new int[sLen + 1][tLen + 1];

        for (int i = 0; i < sLen; ++i) {
            for (int j = 0; j < tLen; ++j) {
                if (s.charAt(i) == t.charAt(j)) {
                    dpl[i + 1][j + 1] = 1 + dpl[i][j];
                }
            }
        }

        for (int i = sLen - 1; i >= 0; --i) {
            for (int j = tLen - 1; j >= 0; --j) {
                if (s.charAt(i) == t.charAt(j)) {
                    dpr[i][j] = 1 + dpr[i + 1][j + 1];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < sLen; ++i) {
            for (int j = 0; j < tLen; ++j) {
                if (s.charAt(i) != t.charAt(j)) {
                    res += (dpl[i][j] + 1) * (1 + dpr[i + 1][j + 1]);
                }
            }
        }
        return res;
    }
}
