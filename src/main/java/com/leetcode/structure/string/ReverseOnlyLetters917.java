package com.leetcode.structure.string;

public class ReverseOnlyLetters917 {
    public String reverseOnlyLetters(String s) {
        final StringBuilder builder = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetter(s.charAt(left))) {
                ++left;
                continue;
            }
            if (!Character.isLetter(s.charAt(right))) {
                --right;
                continue;
            }

            final char temp = builder.charAt(left);
            builder.setCharAt(left++, builder.charAt(right));
            builder.setCharAt(right--, temp);
        }
        return builder.toString();
    }
}
