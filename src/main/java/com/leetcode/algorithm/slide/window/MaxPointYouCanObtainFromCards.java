package com.leetcode.algorithm.slide.window;

public class MaxPointYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;

        int totalSum = cardPoints[0];
        int subSum = cardPoints[0];
        int sublen = len - k;
        for (int i = 1; i < sublen; ++i) {
            subSum += cardPoints[i];
            totalSum = subSum;
        }

        int minSum = subSum;
        for (int i = sublen; i < len; ++i) {
            totalSum += cardPoints[i];
            subSum += cardPoints[i] - cardPoints[i - sublen];
            minSum = Math.min(subSum, minSum);
        }

        return totalSum - minSum;
    }
}
