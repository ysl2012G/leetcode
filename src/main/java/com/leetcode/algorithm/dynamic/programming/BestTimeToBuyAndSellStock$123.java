package com.leetcode.algorithm.dynamic.programming;

public class BestTimeToBuyAndSellStock$123 {
    public int maxProfit(int[] prices) {
        final int times = 2;
        final int days = prices.length;

        final int[] local = new int[times + 1];
        final int[] global = new int[times + 1];

        for (int i = 1; i < days; ++i) {
            final int profit = prices[i] - prices[i - 1];
            for (int j = times; j > 0; --j) {
                local[j] = Math.max(global[j - 1] + Math.max(profit, 0), local[j] + profit);
                global[j] = Math.max(global[j], local[j]);
            }
        }

        return global[times];

//        final int[][] local = new int[days][times + 1];
//        final int[][] global = new int[days][times + 1];
//
//        for (int i = 1; i < days; ++i) {
//            final int profit = prices[i] - prices[i - 1];
//            for (int j = 1; j <= times; ++j) {
//                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(0, profit), local[i - 1][j] + profit);
//                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
//            }
//        }
//
//        return global[days - 1][times];
    }
}
