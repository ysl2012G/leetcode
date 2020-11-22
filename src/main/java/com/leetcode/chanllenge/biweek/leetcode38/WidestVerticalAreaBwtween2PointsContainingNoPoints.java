package com.leetcode.chanllenge.biweek.leetcode38;

import java.util.Arrays;

public class WidestVerticalAreaBwtween2PointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        final int[] xAxis = new int[points.length];
        for (int i =0; i < points.length; ++i) {
            xAxis[i] = points[i][0];
        }

        Arrays.sort(xAxis);
        int maxWidth = 0;
        for (int i = 1; i < xAxis.length; ++i) {
            maxWidth = Math.max(maxWidth, xAxis[i] - xAxis[i - 1]);
        }
        return maxWidth;
    }
}
