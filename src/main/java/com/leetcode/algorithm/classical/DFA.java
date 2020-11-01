package com.leetcode.algorithm.classical;

public class DFA {
    public int strStr(String haystack, String needle) {
        return dfa(haystack, needle);
    }

    private int dfa(String haystack, String needle) {
        if (haystack == null ) {
            return -1;
        }
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int[][] dfa = getDFA(needle);
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        int i = 0;
        int j = 0;
        while (i < haystackLen && j < needleLen) {
            j = dfa[haystack.charAt(i++)][j];
        }
        if (j == needleLen) {
            return i - needleLen;
        } else {
            return - 1;
        }
    }

    private int[][] getDFA(String needle) {
        int strLen = needle.length();
        int charLen = 256;
        int[][] dfa = new int[charLen][strLen];
        dfa[needle.charAt(0)][0] = 1;
        for (int prefix = 0, j = 1; j < strLen; j++) {
            for (int c = 0; c < charLen; c++) {
             dfa[c][j] = dfa[c][prefix];
            }
            dfa[needle.charAt(j)][j] = j + 1;
            prefix = dfa[needle.charAt(j)][prefix];
        }
        return dfa;
    }
}
