package com.leetcode.structure.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification$68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        final int LEN = words.length;
        final List<String> justified = new ArrayList<>();

        int start = 0;
        int wordsLen = 1;
        int currentLen = words[0].length();
        for (int i = 1; i < LEN; ++i) {
            if (currentLen + 1 + words[i].length() <= maxWidth) {
                currentLen += 1 + words[i].length();
                ++wordsLen;
            } else {
                if (wordsLen == 1) {
                    justified.add(buildTrailingLine(words, start, wordsLen, maxWidth - currentLen));
                } else {
                    justified.add(buildStandardLine(words, start, wordsLen, maxWidth - currentLen));
                }
                start = i;
                wordsLen = 1;
                currentLen = words[i].length();
            }
        }

        justified.add(buildTrailingLine(words, start, wordsLen, maxWidth - currentLen));


        return justified;
    }

    private String buildStandardLine(String[] words, int start, int wordsLen, int remainSpace) {
        final StringBuilder builder = new StringBuilder();

        final int evenSpace = remainSpace / (wordsLen - 1);
        final int extraSpace = remainSpace % (wordsLen - 1);

        for (int i = 0; i < wordsLen - 1; ++i) {
            builder.append(words[i + start]).append(' ');
            if (i < extraSpace) {
                builder.append(' ');
            }
            for (int count = 0; count < evenSpace; ++count) {
                builder.append(' ');
            }
        }
        builder.append(words[start + wordsLen - 1]);
        return builder.toString();
    }

    private String buildTrailingLine(String[] words, int start, int wordsLen, int remainSpace) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < wordsLen - 1; ++i) {
            builder.append(words[i + start]).append(' ');
        }
        builder.append(words[start + wordsLen - 1]);
        for (int counter = 0; counter < remainSpace; ++counter) {
            builder.append(' ');
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        final String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        new TextJustification$68().fullJustify(words, 20).forEach(System.out::println);

        System.out.println("enough to explain to".length());
    }





}
