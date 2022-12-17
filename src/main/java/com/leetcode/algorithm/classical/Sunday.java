package com.leetcode.algorithm.classical;

import java.util.Arrays;
import java.util.Objects;

public class Sunday {
    public int strStr(String haystack, String needle) {
        Objects.requireNonNull(haystack, "null haystack");
        Objects.requireNonNull(needle, "null needle");
        return sunday(haystack, needle);
    }


    private int sunday(String haystack, String needle) {
        final int[] shift = buildShift(needle);
        final int HAY_LEN = haystack.length();
        final int NEE_LEN = needle.length();

        int curr = 0;

        while (curr <= HAY_LEN - NEE_LEN) {
            int pos = 0;
            while (pos < NEE_LEN && haystack.charAt(curr + pos) == needle.charAt(pos)) {
                ++pos;
            }
            if (pos == NEE_LEN) {
                return curr;
            }
            if (curr == HAY_LEN - NEE_LEN) {
                break;
            }
            curr += shift[haystack.charAt(curr + NEE_LEN)];
        }
        return -1;
    }

    private int[] buildShift(String needle) {
        final int RADIX = 256;
        final int LEN = needle.length();
        final int[] shifts = new int[RADIX];

        Arrays.fill(shifts, LEN + 1);

        for (int i = 0; i < LEN; ++i) {
            shifts[needle.charAt(i)] = LEN - i;
        }
        return shifts;
    }

    public static void main(String[] args) {
        Sunday sunday = new Sunday();
        System.out.println(sunday.sunday("aaaaa", "bba"));
    }

}
