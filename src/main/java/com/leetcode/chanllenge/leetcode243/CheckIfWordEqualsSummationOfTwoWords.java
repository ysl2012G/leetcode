package com.leetcode.chanllenge.leetcode243;

public class CheckIfWordEqualsSummationOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getLetterValue(firstWord) + getLetterValue(secondWord) == getLetterValue(targetWord);
    }

    private int getLetterValue(String s) {
        int value = 0;
        for (char ch : s.toCharArray()) {
            value = value * 10 + (ch - 'a');
        }
        return value;
    }
}
