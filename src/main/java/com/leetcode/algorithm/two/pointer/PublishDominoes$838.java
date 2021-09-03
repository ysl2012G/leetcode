package com.leetcode.algorithm.two.pointer;

public class PublishDominoes$838 {
    public String pushDominoes(String dominoes) {
        final int len = dominoes.length();




        final StringBuilder builder = new StringBuilder(dominoes);

        final int[] forces = new int[len];

        for (int i = 1; i < len; ++i) {
            if (builder.charAt(i - 1) == 'R' && builder.charAt(i) == '.') {
                builder.setCharAt(i, 'R');
                forces[i] = forces[i - 1] + 1;
            }
        }

        for (int i = len - 2; i >= 0; --i) {
            if (builder.charAt(i + 1) != 'L') { continue; }
            final int curr = forces[i + 1] + 1;
            if (builder.charAt(i) == '.' || forces[i] > curr) {
                builder.setCharAt(i, 'L');
                forces[i] = curr;
            }else if (builder.charAt(i) == 'R' && forces[i] == curr) {
                builder.setCharAt(i, '.');
            }
        }

        return builder.toString();

    }
}
