package com.leetcode.chanllenge.leetcode224;

import java.util.Arrays;

public class NumberOfRectanglesThatCanFormLargestSquare {
    public int countGoodRectangles(int[][] rectangles) {
        final int number = rectangles.length;
        final int[] squares = new int[number];
        for (int i = 0; i < number; ++i) {
            squares[i] = Math.min(rectangles[i][0], rectangles[i][1]);
        }
        Arrays.sort(squares);
        final int maxLen = squares[number - 1];
        int count = 1;
        for (int i = number - 2; i >=0; --i) {
            if (squares[i] == maxLen) {
                ++count;
            } else {
                break;
            }
        }
        return count;
    }
}
