package com.leetcode.chanllenge.leetcode243;

public class MaxValueAfterInsertion {
    public String maxValue(String n, int x) {
        final boolean negative = n.charAt(0) == '-';

        final StringBuilder sb = new StringBuilder();
        int index = negative ? 1 : 0;
        for (; index < n.length(); ++index) {
            final int val = n.charAt(index) - '0';
            final boolean insert = negative ? x < val : x > val;
            if (insert) {
                break;
            }
        }

        sb.append(n.substring(0, index));
        sb.append(x);
        if (index < n.length()) {
            sb.append(n.substring(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new MaxValueAfterInsertion().maxValue("-13", 9);
    }
}
