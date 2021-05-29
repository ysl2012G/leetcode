package com.leetcode.chanllenge.leetcode229;

public class MergeStringAlternative {

    public String mergeAlternately(String word1, String word2) {
        final StringBuilder sb = new StringBuilder();

        int index1 = 0;
        int index2 = 0;
        final int len1 = word1.length();
        final int len2 = word2.length();

        while (index1 < len1 && index2 < len2) {
            sb.append(word1.charAt(index1++));
            sb.append(word2.charAt(index2++));
        }

        if (index1 < len1) {
            sb.append(word1.substring(index1));
        }
        if (index2 < len2) {
            sb.append(word2.substring(index2));
        }

        return sb.toString();
    }
}
