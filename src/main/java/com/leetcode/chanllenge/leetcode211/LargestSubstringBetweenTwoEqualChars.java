package com.leetcode.chanllenge.leetcode211;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualChars {
    public int maxLengthBetweenEqualCharacters(String s) {
        final int[] cache = new int[26];
        Arrays.fill(cache, -1);
        int res = -1;
        for (int i = 0; i < s.length(); ++i) {
            final char ch = s.charAt(i);
            final int index = ch - 'a';
            if (cache[index] < 0) {
                cache[index] = i;
            }  else {
                res = Math.max(res, i - cache[index] - 1);
            }
        }
        return res;
    }
}
