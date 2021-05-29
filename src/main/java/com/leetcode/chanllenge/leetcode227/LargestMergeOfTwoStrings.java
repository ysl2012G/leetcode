package com.leetcode.chanllenge.leetcode227;

public class LargestMergeOfTwoStrings {
    public String largestMerge(String word1, String word2) {
        final StringBuilder builder = new StringBuilder();
        final int len1 = word1.length();
        final int len2 = word2.length();

        int i1 = 0;
        int i2 = 0;

        while (i1 < len1 && i2 < len2) {
            final char ch1 = word1.charAt(i1);
            final char ch2 = word2.charAt(i2);

            if (ch1 > ch2) {
                builder.append(ch1);
                ++i1;
            } else if (ch1 < ch2) {
                builder.append(ch2);
                ++i2;
            } else {
                if (word1.substring(i1).compareTo(word2.substring(i2)) > 0) {
                    builder.append(ch1);
                    ++i1;
                } else {
                    builder.append(ch2);
                    ++i2;
                }
            }
        }

        if (i1 < len1) {
            builder.append(word1.substring(i1));
        }
        if (i2 < len2) {
            builder.append(word2.substring(i2));
        }
        return builder.toString();
    }
}
