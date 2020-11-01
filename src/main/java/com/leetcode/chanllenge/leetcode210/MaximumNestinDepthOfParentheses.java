package com.leetcode.chanllenge.leetcode210;

public class MaximumNestinDepthOfParentheses {

    public int maxDepth(String s) {
        int depth = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++count;
                depth = Math.max(depth, count);
            } else if (c == ')') {
                --count;
            }
        }
        return depth;
    }
}
