package com.leetcode.chanllenge.leetcode234;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDiffrentIntegersInStr {

    public int numDiffferentIntegers(String word) {

        final Set<String> cache = new HashSet<>();

        int previous = 0;
        int curr = 0;

        for (int i = 0; i < word.length(); ++i) {
            final char ch = word.charAt(i);
            if (Character.isDigit(ch)) {
                ++curr;
            } else{
                if (previous != curr) {
                    cache.add(removeLeadingZeros(word.substring(previous, curr)));
                }
                ++curr;
                previous = curr;
            }
        }

        if (previous != curr) {
            cache.add(removeLeadingZeros(word.substring(previous, curr)));
        }

        return cache.size();
    }

    private String removeLeadingZeros(String str) {
        int index = 0;
        for (; index < str.length(); ++index) {
            final char ch = str.charAt(index);
            if (ch != '0') {
                break;
            }
        }
        return str.substring(index);
    }
}
