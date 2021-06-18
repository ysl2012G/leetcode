package com.leetcode.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram$84 {
    public int largestRectangleArea(int[] heights) {
        final int[] processed = new int[heights.length + 1];
        for (int i = 0; i < heights.length; ++i) {
            processed[i] = heights[i];
        }

        final Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i < processed.length; ++i) {
            while (!stack.isEmpty() && processed[stack.peek()] >= processed[i]) {
                final int curr = stack.pop();
                final int currArea = processed[curr] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                maxArea = Math.max(maxArea, currArea);
            }
            stack.push(i);;
        }

        return maxArea;
    }
}
