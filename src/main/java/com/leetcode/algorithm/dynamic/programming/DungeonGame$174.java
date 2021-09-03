package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;

public class DungeonGame$174 {
    public int calculateMinimumHP(int[][] dungeon) {
        final int row = dungeon.length;
        final int col = dungeon[0].length;

        // 逆推
        final int[] memo = new int[col + 1];
        memo[col] = 1;
        Arrays.fill(memo, Integer.MAX_VALUE);

        for (int i = row - 1; i >= 0; --i ) {
            for (int j = col - 1; j >= 0; -- j) {
                memo[j] = Math.max(1, Math.min(memo[j], memo[j + 1]) - dungeon[i][j]);
            }
        }
        return memo[0];

    }
}
