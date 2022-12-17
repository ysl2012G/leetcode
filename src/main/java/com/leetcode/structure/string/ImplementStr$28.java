package com.leetcode.structure.string;

import java.util.Arrays;

public class ImplementStr$28 {
    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    private int kmp(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int[] next = generatePrefixArray(needle);

        int hayStackLen = haystack.length();
        int needleLen = needle.length();
        int i = 0;
        int j = 0;
        while (i < hayStackLen && j < needleLen) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j == needleLen) {
            return i - j ;
        }
        return -1;
    }

    private int[]  generatePrefixArray(String needle) {
        int strLen = needle.length();
        int[] next = new int[strLen];
        next[0] = -1;
        int prev = -1;
        int curr = 0;
        while (curr < strLen - 1) {
            if (prev == -1 || needle.charAt(prev) == needle.charAt(curr)) {
                ++prev;
                ++curr;
                //Extra optimized
                if (needle.charAt(curr) != needle.charAt(prev)) {
                    next[curr] = prev;
                } else {
                    next[curr] = next[prev];
                }
            } else {
                prev = next[prev];
            }
        }
        return next;
    }



    /**
     * Impelment <a href="https://www-igm.univ-mlv.fr/~lecroq/string/node14.html"> Bayer-Moore algorithm</a>
     */
    private int bayerMoore(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        processBadChars(needle);
        processGoodSuffix(needle);
        //TODO
        return 0;
    }

    private int[] badChars = new int[256];
    private void processBadChars(String needle) {
        int strLen = needle.length();
        Arrays.fill(badChars, strLen);
        for (int i = 0; i < strLen ; i++) {
            badChars[needle.charAt(i)] = strLen - 1 - i;
        }
    }

    private int[] goodSuffix;
    private void processGoodSuffix(String needle) {
        int strLen = needle.length();
        goodSuffix = new int[strLen];
        Arrays.fill(goodSuffix, strLen);
        processSuffix(needle);

        int j = 0;
		for (int i = strLen - 1; i >= 0; i--) {
            if (suffix[i] == i + 1) {
				for (; j < strLen - 1 - i; j++) {
					if (goodSuffix[j] == strLen) {
						goodSuffix[j] = strLen - 1 - i;
					}
				}
            }
		}

		for(int i = 0; i <= strLen - 2; i++) {
            goodSuffix[strLen -1 - suffix[i]] = strLen - 1 - i;
        }

    }

    private int[] suffix;
    private void processSuffix(String needle) {
        int strLen = needle.length();
        suffix = new int[strLen];
        suffix[strLen - 1] = strLen;

        int matchStart = 0;
        int matchEnd = strLen - 1;

		for (int i = strLen - 2; i >= 0; i--) {
            if (i > matchEnd && suffix[i + strLen - 1 - matchStart] < i - matchEnd) {
                suffix[i] =suffix[i + strLen -1 - matchStart];
            } else {
                if (i < matchEnd) {
                    matchEnd = i;
                }
                matchStart = i;
                while ( matchEnd >= 0 && needle.charAt(matchEnd) == needle.charAt(matchEnd + strLen - 1 - matchStart)) {
                    -- matchEnd;
                }
                suffix[i] = matchStart - matchEnd;
            }
		}
    }









    public static void main(String[] args) {
        new ImplementStr$28().generatePrefixArray("abab");
    }
}
