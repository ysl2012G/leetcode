package com.leetcode.chanllenge.biweek.leetcode51;

public class ReplaceAllDigitsWithChars {
    public String replaceDigits(String s) {
        final int LEN = s.length();
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < LEN; ++i) {
            if (i % 2 == 0) {
                builder.append(s.charAt(i));
            } else {
                final char ch = s.charAt(i - 1);
                final int offset = s.charAt(i) - '0';
                builder.append((char)(ch + offset));
            }
        }
        return builder.toString();
    }
}
