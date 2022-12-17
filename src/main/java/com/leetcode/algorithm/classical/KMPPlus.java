package com.leetcode.algorithm.classical;

public class KMPPlus {
    private final String pattern;
    private final int patLen;
    private final int[] next;

    public KMPPlus(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("pattern is empty");
        }

        this.pattern = pattern;
        this.patLen = pattern.length();
        this.next = new int[patLen];

        int j = -1;
        for (int i = 0; i < patLen; ++i) {
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
    }

    public int search(String text) {
        final int textLen = text.length();
        int i = 0;
        int j = 0;
        for (; i < textLen && j < patLen; ++i) {
            while (j >= 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            ++j;
        }
        if (j == patLen) {
            return i - patLen;
        }
        return -1;
    }


    public static void main(String[] args) {
        final KMPPlus solution = new KMPPlus("abc");
        System.out.println(solution.search("bcabc"));
    }
}
