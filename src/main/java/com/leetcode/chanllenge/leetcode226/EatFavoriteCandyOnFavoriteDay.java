package com.leetcode.chanllenge.leetcode226;

public class EatFavoriteCandyOnFavoriteDay {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        final long[] prefixSum = new long[candiesCount.length + 1];

        for (int i = 0; i < candiesCount.length; ++i) {
            prefixSum[i + 1] = prefixSum[i] + candiesCount[i];
        }

        final boolean[] canEat = new boolean[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            final int type = queries[i][0];
            final int day = queries[i][1];
            final int dailyCandy = queries[i][2];

            final int lowConsume = day + 1;
            final long highConsume = (day + 1) * dailyCandy;

            canEat[i] = highConsume > prefixSum[type] && lowConsume <= prefixSum[type + 1];
        }

        return canEat;

    }

    public static void main(String[] args) {

    }
}
