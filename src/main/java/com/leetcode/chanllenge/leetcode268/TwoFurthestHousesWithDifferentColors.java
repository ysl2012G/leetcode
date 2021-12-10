package com.leetcode.chanllenge.leetcode268;

public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        final int len = colors.length;
        int searchFromLeft = 0;
        final int leftColor = colors[0];
        for (int i = len - 1; i >= 0; --i) {
            if (colors[i] != leftColor) {
                searchFromLeft = i;
                break;
            }
        }

        int searchFromRight = 0;
        final int rightColor = colors[len - 1];
        for (int i = 0; i < len;  ++i) {
            if (colors[i] != rightColor) {
                searchFromRight = len - 1 - i;
                break;
            }
        }

        return Math.max(searchFromLeft, searchFromRight);
    }
}
