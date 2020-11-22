package com.leetcode.chanllenge.leetcode216;

import java.util.Objects;

public class CheckIfTwoStringsAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        final StringBuilder build1 = new StringBuilder();
        for (String word : word1) {
            build1.append(word);
        }
        final StringBuilder build2 = new StringBuilder();
        for (String word: word2) {
            build2.append(word);
        }
        return Objects.equals(build1.toString(), build2.toString());
    }
}
