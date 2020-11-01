package com.leetcode.algorithm.classical;

public class KMP {
    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    private int kmp(String haystack, String needle) {
        if (haystack == null ) {
            return -1;
        }
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        int[] prefixes = getPrefixArray(needle);
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        int i = 0;
        int j = 0;
        while (i < haystackLen && j < needleLen) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = prefixes[j];
            }
        }
        if (j == needleLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] getPrefixArray(String needle) {
        int strLen = needle.length();
        int[] prefixes = new int[strLen];
        int prev = -1;
        int curr = 0;
        prefixes[0] = -1;

        while (curr < strLen - 1) {
            if (prev == -1 || needle.charAt(prev) == needle.charAt(curr)) {
                ++prev;
                ++curr;
                if (needle.charAt(prev) != needle.charAt(curr)) {
                    prefixes[curr] = prev;
                } else {
                    prefixes[curr] = prefixes[prev];
                }

            } else {
                prev = prefixes[prev];
            }
        }
        return  prefixes;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new KMP().kmp(haystack, needle));
    }

}
