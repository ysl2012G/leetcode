package com.leetcode.algorithm.two.pointer;

import org.junit.jupiter.api.Test;

public class IntervalListIntersections$986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }
        final int firstLen = firstList.length;
        final int secondLen = secondList.length;

        final int[][] ans = new int[firstLen + secondLen][2];
        int firstIndex = 0;
        int secondIndex = 0;
        int index = 0;
        while (firstIndex < firstLen && secondIndex < secondLen) {
            final int firstLeft = firstList[firstIndex][0];
            final int firstRight = firstList[firstIndex][1];

            final int secondLeft = secondList[secondIndex][0];
            final int secondRight = secondList[secondIndex][1];

            final int leftBound = Math.max(firstLeft, secondLeft);;
            final int rightBound = Math.min(firstRight, secondRight);

            if (leftBound <= rightBound) {
                ans[index][0] = leftBound;
                ans[index][1] = rightBound;
                ++index;
            }

            if (rightBound == firstRight) {
                ++firstIndex;
            } else {
                ++secondIndex;
            }
        }

        final int[][] res = new int[index][0];
        System.arraycopy(ans, 0, res, 0, index);
        return res;
    }

    @Test
    public void test() {
        final int[][] firstList = {{0,2}, {5,10}, {13,23}, {24,25}};
        final int[][] secondList = {{1,5}, {8,12}, {15,24}, {25,26}};
        final IntervalListIntersections$986 solution = new IntervalListIntersections$986();
        solution.intervalIntersection(firstList, secondList);
    }
}
