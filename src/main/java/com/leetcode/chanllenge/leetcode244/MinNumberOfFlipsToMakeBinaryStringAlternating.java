package com.leetcode.chanllenge.leetcode244;

public class MinNumberOfFlipsToMakeBinaryStringAlternating {
    public int minFlips(String s) {
        final int LEN = s.length();
        final int[][] cache = new int[2][2];


        // Cache[0][0] number of '0' in even position
        // Cache[0][1] number of '0' in old position
        // Cache[1][0] number of '1' in even position
        // Cache[1][1] number of '1' in old position

        for (int i = 0; i < LEN; ++i) {
            ++cache[s.charAt(i) - '0'][i % 2];
        }

        final int startAtOne = cache[1][0] + cache[0][1];
        final int startAtZero = cache[1][1] + cache[0][0];

        int res = Math.min(startAtOne, startAtZero);

        for (int i = 0; i < LEN; ++i) {
            // sending first characters to tail
            --cache[s.charAt(i) - '0'][i % 2];
            ++cache[s.charAt(i) - '0'][(LEN + i) % 2];
            res = Math.min(res, cache[1][0] + cache[0][1]);
            res = Math.min(res, cache[0][0] + cache[1][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        final int res = new MinNumberOfFlipsToMakeBinaryStringAlternating().minFlips("10001100101000000");
        System.out.println(res);
    }

}
