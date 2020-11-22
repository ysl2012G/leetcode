package com.leetcode.chanllenge.leetcode215;

import java.util.Arrays;

public class DetermineTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        final int LEN = 26;
        final int[] occurrence1 = new int[LEN];
        final int[] occurrence2 = new int[LEN];

        for (char ch : word1.toCharArray()) {
            ++occurrence1[ch - 'a'];
        }
        for (char ch : word2.toCharArray()) {
            ++occurrence2[ch - 'a'];
        }

        for (int i = 0; i < LEN; ++i) {
            if ((occurrence1[i] == 0) ^ (occurrence2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(occurrence1);
        Arrays.sort(occurrence2);
        for (int i = 0; i < LEN; ++i) {
            if (occurrence1[i] != occurrence2[i]) {
                return false;
            }
        }

        return true;

    }

}
