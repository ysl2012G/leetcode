package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;

public class PalindromePartitioning$132 {



    public int minCut(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return 0;
        }
        final int[] span = buildSpan(s);

        final int len = s.length();
        final int[] cut = new int[len];

        int min = len;
        for (int i = 1; i < len; ++i) {
            min = i;
            for (int j = 0; j < i; ++j) {
                if (isPalindrome(span, j, i)) {
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            min = Math.min(min, cut[i  - 1] + 1);
            cut[i] = min;
        }

        return cut[len - 1];
    }

    private boolean isPalindrome(int[] span, int lo, int hi) {
        final int left = lo * 2 + 1;
        final int right = hi * 2 + 1;
        final int mid = (left + right) / 2;
        final int expectedArm = mid - left + 1;
        return span[mid] >= expectedArm;
    }


    private int[] buildSpan(String s) {
        final StringBuilder builder = new StringBuilder();
        builder.append('#');
        for (char ch : s.toCharArray()) {
            builder.append(ch).append('#');
        }
        final int len = builder.length();
        final int[] span = new int[len];
        Arrays.fill(span, 1);

        int center = 0;
        int arm = 1;
        for (int i = 1; i < len; ++i) {
            final int reach = center + arm - 1;
            if (i >= reach ) {
                center = i;
                span[i] = calculateArm(builder, i, arm);
            } else {
                final int mirror = span[2 * i - reach];
                if (i + mirror - 1 < reach) {
                    span[i] = mirror;
                } else if (i + mirror  - 1 > reach) {
                    span[i] = reach - i + 1;
                } else {
                    center = i;
                    arm = mirror;
                    span[i] = calculateArm(builder, i, arm);
                }
            }
        }

        return span;
    }

    private int calculateArm(StringBuilder builder, int center, int arm) {
        while (center >= arm && center + arm < builder.length() && builder.charAt(center - arm) == builder.charAt(center + arm)) {
            ++arm;
        }
        return arm;
    }




    public static void main(String[] args) {
        new PalindromePartitioning$132().minCut("aab");
    }

}
