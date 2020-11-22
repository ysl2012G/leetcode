package com.leetcode.chanllenge.biweek.leetcode38;

public class NumberOfWays2FromTargetString {
    public int numWays(String[] words, String target) {
        final long MOD = (long) (1e9 + 7);
        final int wordLen = words[0].length();

        final int targetLen = target.length() ;
        final int[] ways = new int[targetLen + 1];
        ways[0] = 1;
        for (int i = 0; i < wordLen; ++i) {
            final int[] freq = new int[26];
            for (String word : words ) {
                ++freq[word.charAt(i) - 'a'];
            }
            for (int j = targetLen - 1; j >= 0; --j) {
                ways[j + 1] += ways[j] * freq[target.charAt(j) - 'a'] ;
            }
        }
        return (int) (ways[targetLen] % MOD);
    }

    public static void main(String[] args) {
        final String[] words = {"acca", "bbbb", "caca"};
        new NumberOfWays2FromTargetString().numWays(words, "abd");
    }
}
