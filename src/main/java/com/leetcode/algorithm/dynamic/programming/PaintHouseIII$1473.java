package com.leetcode.algorithm.dynamic.programming;

public class PaintHouseIII$1473 {
    private static final int MAX_VALUE = 100_000_000;
    private int[] houses;
    private int[][] cost;
    private int m;
    private int n;
    private int target;
    private Integer[][][] memo;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        this.memo = new Integer[m][n + 1][target + 1];
        final int ans = dfs(0, 0, target);
        return ans < MAX_VALUE ? ans : -1;
    }

    private int dfs(int houseIndex, int prevColor, int remainTarget) {
        if (houseIndex == m || remainTarget < 0 || m - houseIndex < remainTarget) {
            if (remainTarget == 0 && houseIndex == m) {
                return 0;
            } else {
                return MAX_VALUE;
            }
        }

        if (memo[houseIndex][prevColor][remainTarget] != null) {
            return memo[houseIndex][prevColor][remainTarget];
        }

        final int currentColor = houses[houseIndex];
        if (currentColor != 0) {
            return memo[houseIndex][prevColor][remainTarget] = dfs(houseIndex + 1, currentColor, remainTarget - (currentColor == prevColor ? 0 : 1));
        }
        int ans = Integer.MAX_VALUE;
        for (int color = 1; color <= n; ++color) {
            final int val = dfs(houseIndex + 1, color, remainTarget - (color == prevColor ? 0 : 1));
            ans = Math.min(ans, val + cost[houseIndex][color - 1]);
        }

        return memo[houseIndex][prevColor][remainTarget] = ans;
    }
}
