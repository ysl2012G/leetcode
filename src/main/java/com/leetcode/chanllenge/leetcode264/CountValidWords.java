package com.leetcode.chanllenge.leetcode264;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class CountValidWords {
    private static final Set<Character> PUNCTUATIONS = new HashSet<>(Arrays.asList('!', '.', ','));


    public int countValidWords(String sentence) {
        final String[] words = sentence.split("\\s+", -1);
        return (int) Arrays.stream(words).filter(this::isValidWord).count();
    }

    private boolean isValidWord(String word) {
        final int len = word.length();

        final char lastChar = word.charAt(len - 1);
        if (!Character.isLowerCase(lastChar) && !PUNCTUATIONS.contains(lastChar)) {
            return false;
        }

        if (len == 1) {
            return true;
        }

        final char firstChar = word.charAt(0);
        if (!Character.isLowerCase(firstChar)) {
            return false;
        }


        boolean hyphen = false;
        for (int i = 1; i < len - 1; ++i) {
            final char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                continue;
            }
            if (ch == '-') {
                if (hyphen || !Character.isLowerCase(word.charAt(i + 1))) {
                    return false;
                }
                hyphen = true;
                continue;
            }
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        final CountValidWords solution = new CountValidWords();
        solution.countValidWords("!g 3 !sy ");
    }
}
