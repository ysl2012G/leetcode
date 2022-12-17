package com.leetcode.algorithm.sort;

import java.util.Arrays;

public class KClosetPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        final int[][] res = new int[k][2];
        for (int i = 0; i < k; ++i) {
            res[i] = points[i];
        }
        return res;
    }
}
