package com.leetcode.chanllenge.leetcode235;

public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        final String[] fields = s.split(" ", -1);

        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k - 1; ++i) {
            builder.append(fields[i]).append(" ");
        }
        builder.append(fields[k - 1]);
        return builder.toString();
    }
}
