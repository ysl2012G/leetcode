package com.leetcode.chanllenge.biweek.leetcode45;

public class MinLengthOfStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (right == left) {
            return 1;
        }

        char ch = s.charAt(left);
        while (s.charAt(left) == s.charAt(right) && left < right) {
            ch = s.charAt(left);
            if (s.charAt(left + 1) == ch) {
                ++left;
                continue;
            }
            if (s.charAt(right - 1) == ch) {
                --right;
                continue;
            }
            ++left;
            --right;
        }

        if (left < right) {
            return right - left + 1;
        } else {
            return s.charAt(right) == ch ? 0 : 1;
        }

    }

    public static void main(String[] args) {
        final int len = new MinLengthOfStringAfterDeletingSimilarEnds().minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb");
        System.out.println(len);
    }
}
