package com.leetcode.algorithm.slide.window;

public class MinimumWindowsSubstring$76 {
    public String minWindow(String s, String t) {
        final int[] cache = new int[128];

        for (char ch : t.toCharArray()) {
            ++cache[ch];
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = -1;
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            final char ch = s.charAt(i);
            if (--cache[ch] >= 0) {
                ++cnt;
            }
            while (cnt == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    minLeft = left;
                }
                if (++cache[s.charAt(left++)] > 0) {
                    --cnt;
                }
            }
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        final String s = "ADOBECODEBANC";
        final String t = "ABC";

        new MinimumWindowsSubstring$76().minWindow(s, t);
    }
}
