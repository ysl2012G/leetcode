package com.leetcode.chanllenge.biweek.leetcode52;

public class SortSentence {
    public String sortSentence(String s) {
        final String[] fields = s.split("\\s+", -1);
        final String[] sorted = new String[fields.length];
        for (String field : fields) {
            final int LEN = field.length();
            int index = field.charAt(LEN - 1) - '1';
            sorted[index] = field.substring(0, LEN - 1);
        }

        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length - 1; ++i) {
            builder.append(sorted[i]).append(" ");
        }
        builder.append(sorted[fields.length - 1]);

        return builder.toString();
    }

    public static void main(String[] args) {
        final String str = "is2 sentence4 This1 a3";
        new SortSentence().sortSentence(str);
    }
}
