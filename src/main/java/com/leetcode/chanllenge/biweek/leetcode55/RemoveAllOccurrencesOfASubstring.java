package com.leetcode.chanllenge.biweek.leetcode55;

import java.util.Arrays;

public class RemoveAllOccurrencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        final StringBuilder builder = new StringBuilder(s);

//        final int[] shift = buildShiftArray(part);
        final int[] next = buildNextArray(part);
        final int partLen = part.length();

        while (true) {
//            final int index = substringBySunday(builder, part, shift);
            final int index = substringByKMP(builder, part, next);
            if (index == -1 ) {
                break;
            }
            builder.delete(index, index + partLen);
        }

        return builder.toString();
    }

    private int substringBySunday(StringBuilder builder, String pattern, int[] shift) {
        final int sLen = builder.length();
        final int patLen = pattern.length();
        int curr = 0;
        while (curr <= sLen - patLen) {
            int pos = 0;
            while (pos < patLen && builder.charAt(curr + pos) == pattern.charAt(pos)) {
                ++pos;
            }
            if (pos == patLen) {
                return curr;
            }
            if (curr == sLen - patLen) {
                return -1;
            }
            curr += shift[builder.charAt(curr + patLen) - 'a'];
        }
        return -1;
    }

    private int[] buildShiftArray(String pattern) {
        final int RADIX = 26;
        final int PATLEN = pattern.length();
        final int[] shift = new int[RADIX];
        Arrays.fill(shift, PATLEN + 1);

        for (int i = 0; i < PATLEN; ++i) {
            shift[pattern.charAt(i) - 'a'] = PATLEN - i;
        }

        return shift;
    }

    private int substringByKMP(StringBuilder builder, String pattern, int[] next) {
        final int PAT_LEN = pattern.length();
        final int STR_LEN = builder.length();
        int i = 0;
        int j = 0;
        for (; i < STR_LEN && j < PAT_LEN; ++i) {
            while (j >= 0 && builder.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            ++j;
        }
        if (j == PAT_LEN) { return i - PAT_LEN; }
        return -1;
    }

    private int[] buildNextArray(String pattern) {
        final int PAT_LEN = pattern.length();
        final int[] next = new int[PAT_LEN];
        int j = -1;

        for (int i = 0; i < PAT_LEN; ++i) {
            if (i == 0) {
                next[i] = -1;
            } else if (pattern.charAt(i) != pattern.charAt(j)) {
                next[i] = j;
            } else {
                next[i] = next[j];
            }
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            ++j;
        }

        return next;
    }


    public static void main(String[] args) {
        final String s = "daabcbaabcbc";
        final String part = "abc";

        new RemoveAllOccurrencesOfASubstring().buildNextArray("ababc");

        final String res = new RemoveAllOccurrencesOfASubstring().removeOccurrences(s, part);
        System.out.println(res);
    }
}
