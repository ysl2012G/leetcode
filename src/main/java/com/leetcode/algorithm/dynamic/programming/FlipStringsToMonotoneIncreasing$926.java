package com.leetcode.algorithm.dynamic.programming;

public class FlipStringsToMonotoneIncreasing$926 {
    public int minFlipsMonoIncr(String s) {
        int endAtZero = 0;
        int endAtOne = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                endAtOne = Math.min(endAtOne + 1, endAtZero);
            } else {
                endAtZero += 1;
            }
        }

        return Math.min(endAtOne, endAtZero);
    }

    public static void main(String[] args) {

    }
}
