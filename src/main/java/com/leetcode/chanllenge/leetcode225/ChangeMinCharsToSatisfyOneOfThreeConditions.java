package com.leetcode.chanllenge.leetcode225;

public class ChangeMinCharsToSatisfyOneOfThreeConditions {
    public int minCharacters(String a, String b) {
        final int LETTER_LEN = 26;
        final int aLen = a.length();
        final int bLen = b.length();

        final int[] freqA = new int[LETTER_LEN];
        for (int i = 0; i < aLen; ++i) {
            final char aChar = a.charAt(i);
            final int index = aChar - 'a';
            ++freqA[index];
        }

        final int[] freqB = new int[LETTER_LEN];
        for (int i = 0; i < bLen; ++i) {
            final char bChar = b.charAt(i);
            final int index = bChar - 'a';
            ++freqB[index];
        }

        final int[] preSumA = new int[LETTER_LEN + 1];
        final int[] preSumB = new int[LETTER_LEN + 1];
        for (int i = 0; i < LETTER_LEN; ++i) {
            preSumA[i + 1] = preSumA[i] + freqA[i];
            preSumB[i + 1] = preSumB[i] + freqB[i];
        }

        int res = aLen + bLen - freqA[0] - freqB[0];
        for (int i = 1; i < LETTER_LEN; ++i) {
            res = Math.min(res, aLen + bLen - freqA[i] - freqB[i]);
            res = Math.min(res, aLen - preSumA[i] + preSumB[i]);
            res = Math.min(res, bLen - preSumB[i] + preSumA[i]);

        }

        return res;
    }

    public static void main(String[] args) {
        new ChangeMinCharsToSatisfyOneOfThreeConditions().minCharacters("aba", "caa");
    }
}
