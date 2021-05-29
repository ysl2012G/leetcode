package com.leetcode.chanllenge.biweek.leetcode44;

public class DecodeXORArray {
    public int[] decode(int[] encoded) {
        final int len = encoded.length;

        int first = 1;
        for (int i = 1; i <= len; ++i) {
            first ^= i + 1;
            if (i % 2 == 1) {
                first ^= encoded[i];
            }
        }

        final int[] res = new int[len + 1];
        res[0] = first;

        for (int i = 0; i < len; ++i) {
            res[i + 1] = res[i] ^ encoded[i];
        }

        return res;
    }

    public static void main(String[] args) {
        new DecodeXORArray().decode(new int[]{3, 1});
    }
}
