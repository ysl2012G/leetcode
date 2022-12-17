package com.leetcode.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures$739 {
    public int[] dailyTemperatures(int[] temperatures) {
        final int len = temperatures.length;
        final int[] ans = new int[len];

        final Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                final int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);;
        }
        return ans;
    }
}
