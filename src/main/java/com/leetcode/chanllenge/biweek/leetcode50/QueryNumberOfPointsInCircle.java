package com.leetcode.chanllenge.biweek.leetcode50;

public class QueryNumberOfPointsInCircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        final int[] result = new int[queries.length];
        for (int[] point : points) {
            for (int i = 0; i < queries.length; ++i) {
                final int r = queries[i][2];

                final int xLen = point[0] - queries[i][0];
                final int yLen = point[1] - queries[i][1];

                if (xLen * xLen + yLen * yLen <= r * r) {
                    ++result[i];
                }
            }
        }
        return result;
    }
}
