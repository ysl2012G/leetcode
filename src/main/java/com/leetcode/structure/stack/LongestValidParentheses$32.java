package com.leetcode.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses$32 {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        final Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); ++ i) {
            final char ch = s.charAt(i);
            if (ch == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        if (stack.isEmpty()) {
            return s.length();
        }

        int max = 0;
        int a = s.length();
        while (!stack.isEmpty()) {
            final int b = stack.pop();
            max = Math.max(a - b - 1, max);
            a = b;
        }

        return Math.max(max, a);
    }

    public int longestValidParenthesesUseDP(String s) {
        final int LEN = s.length();
        final int[] memo = new int[LEN];

        int max = 0;
        for (int i = 1; i < LEN; ++i) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                memo[i] = i - 2 >= 0 ? memo[i - 2] + 2 : 2;
                max = Math.max(max, memo[i]);
            } else {
                int prevIndex = i - 1 - memo[i - 1];
                if (prevIndex >= 0 && s.charAt(prevIndex) == '(') {
                    memo[i] =memo[i - 1] + 2 + ((prevIndex - 1 >= 0) ? memo[prevIndex - 1] : 0);
                    max = Math.max(max, memo[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new LongestValidParentheses$32().longestValidParentheses("())");
    }
}
