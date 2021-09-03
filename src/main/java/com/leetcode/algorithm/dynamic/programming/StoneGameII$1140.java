package com.leetcode.algorithm.dynamic.programming;

public class StoneGameII$1140 {
    private int[] sums;
    private int[][] memo;
    private int len;

    public int stoneGameII(int[] piles) {
        len = piles.length;
        sums = new int[len];
        System.arraycopy(piles, 0, sums, 0, piles.length);
        for (int i = len - 2; i >= 0; --i) {
            sums[i] += sums[i + 1];
        }

        memo = new int[len][len];

        return helper(0, 1);
    }

    private int helper(int index, int step) {
        if (index == len) {
            return 0;
        }
        if (index + step * 2 >= len) {
            return sums[index];
        }
        if (memo[index][step] > 0) {
            return memo[index][step];
        }

        int max = 0;
        for (int offset = 1; offset <= 2 * step && index + offset <= len; ++offset) {
            max = Math.max(max, sums[index] - helper(index + offset, Math.max(offset, step)));
        }
        memo[index][step] = max;
        return max;
    }



//    public int stoneGameII(int[] piles) {
//        final int len = piles.length;
//        final int[] sums = new int[len];
//        sums[len - 1] = piles[len - 1];
//		for (int i = len - 2; i >= 0; --i) {
//            sums[i] = sums[i + 1] + piles[i];
//		}
//
//		final int[][] memo = new int[len + 1][len + 1];
//		// 从最大值开始算
//		for (int i = 0; i < len; ++i) {
//            memo[i][len] = sums[i];
//        }
//
//		for (int i = len - 1; i >=0; --i) {
//            for (int step = len - 1; step >= 1; -- step) {
//                // i + offset == len, 表示全要
//                for (int offset = 1; offset <= 2 * step && i + offset <= len; ++offset) {
//                    memo[i][step] = Math.max(memo[i][step], sums[i] - memo[i + offset][Math.max(step, offset)]);
//                }
//            }
//        }
//
//		return memo[0][1];
//    }
}
