package com.leetcode.chanllenge.leetcode227;

import java.util.Arrays;

public class MaxScoreFromRemoingStones {
    public int maximumScore(int a, int b, int c) {
        final int[] piles = new int[] {a, b, c};
        Arrays.sort(piles);

        int diff = piles[2] - piles[1];
        if (diff == 0) {
            return piles[1] + piles[0] / 2;
        }

        if (piles[0] < diff) {
            return piles[0] + piles[1];
        } else {
            return diff+ piles[1] + (piles[0] - diff) / 2;
        }
    }

    public static void main(String[] args) {
        final int res = new MaxScoreFromRemoingStones().maximumScore(2, 4, 6);
        System.out.println(res);
    }
}
