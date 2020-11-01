package com.leetcode.algorithm.dynamic.programming;

import java.util.stream.Collectors;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) { return s;}
        return manacher(s);
    }

    private String manacher(String str) {
        final String process = str.chars().mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining("#", "#", "#"));
        int len = process.length();
        final int[] palindrome = new int[len];

        String result = "";
        int center = 0;
        int bound = 0;
        for (int i = 1; i < len - 1; ++i) {
            int mirror = 2 * center - i;
            if (i < bound) {
                palindrome[i] = Math.min(bound - i, palindrome[mirror]);
            }
            int left = i - (palindrome[i] + 1);
            int right = i + (palindrome[i] + 1);
            while (left >= 0 && right < len && process.charAt(left) == process.charAt(right)) {
                --left;
                ++right;
                ++palindrome[i];
            }

            if (i + palindrome[i] > bound) {
                center = i;
                bound = i + palindrome[i];

                if (palindrome[i] > result.length()) {
                    int startIndex = (center - palindrome[i]) >> 1;
                    result = str.substring(startIndex, startIndex + palindrome[i]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubString().longestPalindrome("babab"));

    }
}
