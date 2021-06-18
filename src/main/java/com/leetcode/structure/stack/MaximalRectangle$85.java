package com.leetcode.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle$85 {
    public int maximalRectangle(char[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;
        if (row == 0) {
            return 0;
        }

        final int[] heights = new int[col + 1];

        final Deque<Integer> stack = new LinkedList<>();
        int maxRectangle = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '1') {
                    ++heights[j];
                } else {
                    heights[j] = 0;
                }
            }
            stack.clear();
            for (int k = 0; k <= col; ++k) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[k]) {
                    final int curr = stack.pop();
                    final int currRectangle = heights[curr] * (stack.isEmpty() ? k : (i - stack.peek() - 1));
                    maxRectangle = Math.max(currRectangle, maxRectangle);
                }
                stack.push(k);
            }
        }
        return maxRectangle;
    }
}
