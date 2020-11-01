package com.leetcode.algorithm.classical;

import java.util.Arrays;

public class BayerMoore {
    public int strStr(String haystack, String needle) {
        return bm(haystack, needle);
    }

    private int bm(String haystack, String needle) {
        if (haystack == null ) {
            return -1;
        }
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int[] right = getRightArray(needle);

        int hayLen = haystack.length();
        int neeLen = needle.length();
        int i = 0;
        while (i < hayLen - neeLen) {
            int skip = 0;
            for (int j = neeLen - 1; j >= 0; j--) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    skip = j - right[haystack.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                        break;
                    }
                }
            }
            if (skip == 0) {
                return i;
            }
            i += skip;
        }
        return  -1;
    }

    private int[] getRightArray(String needle) {
        int charLen = 256;
        int strLen = needle.length();
        int[] right = new int[charLen];
        Arrays.fill(right, -1);
        for (int i = 0; i < strLen; i++) {
            right[needle.charAt(i)] = i;
        }
        return right;
    }
}
