package com.leetcode.algorithm.dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaintingGridWithThreeDifferentColors$1931 {
    private int m;
    private int n;
    private Integer[][] memo;
    private Map<Integer, List<Integer>> nextColMasks;

    private static final int MOD = 1_000_000_007;
    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;
        this.memo = new Integer[n][1 << (2 * m)];
        this.nextColMasks = new HashMap<>();
        return dp(0, 0);
    }

    private int dp(int col, int prevColMask) {
        if (col == n) {
            return 1;
        }
        if (memo[col][prevColMask] != null) {
            return memo[col][prevColMask];
        }
        int ans = 0;
        for (int nextColMask : getNextColMasks(prevColMask)) {
            ans = (ans + dp(col + 1, nextColMask)) % MOD;
        }
        memo[col][prevColMask] = ans;
        return memo[col][prevColMask];
    }

    private List<Integer> getNextColMasks(int prevColMask) {
        if (nextColMasks.containsKey(prevColMask)) {
            return nextColMasks.get(prevColMask);
        }
        final List<Integer> out = new ArrayList<>();
        dfs(0, prevColMask, 0, out);
        nextColMasks.put(prevColMask, out);
        return out;
    }

    private void dfs(int row, int prevColMask, int currColMask, List<Integer> out) {
        if (row == m) {
            out.add(currColMask);
            return;
        }
        for (int i = 1; i <= 3; ++i) {
            if (getColor(prevColMask, row) != i && (row == 0 || getColor(currColMask, row - 1) != i)) {
                dfs(row + 1, prevColMask, setColor(currColMask, row, i), out);
            }
        }
    }

    private int getColor(int mask, int pos) {
        return (mask >> (2 * pos)) & 3;
    }

    private int setColor(int mask, int pos, int color) {
        return mask | (color << (2 * pos));
    }

    @Test
    public void test() {
        final PaintingGridWithThreeDifferentColors$1931 solution = new PaintingGridWithThreeDifferentColors$1931();
        Assertions.assertEquals(6, solution.colorTheGrid(1, 2));
    }
}
