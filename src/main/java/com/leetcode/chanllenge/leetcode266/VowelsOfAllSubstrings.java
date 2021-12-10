package com.leetcode.chanllenge.leetcode266;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VowelsOfAllSubstrings {
    public long countVowels(String word) {
        final Set<Character> dict = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        final int len = word.length();
        long ans = 0;
        for (int i = 0; i < len; ++i ) {
            if (dict.contains(word.charAt(i))) {
                ans += ((long) len - i) * (i + 1);
            }
        }
        return ans;
    }

    @Test
    void test() {
        final VowelsOfAllSubstrings solution = new VowelsOfAllSubstrings();
        Assertions.assertEquals(6, solution.countVowels("aba"));
    }
}
