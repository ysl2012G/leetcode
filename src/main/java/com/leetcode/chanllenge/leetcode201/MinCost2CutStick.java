package com.leetcode.chanllenge.leetcode201;

import java.util.Arrays;

/**
 * leetcode: 1547
 */
public class MinCost2CutStick {
    public int minCost(int n, int[] cuts) {
        int cutsLen = cuts.length;
        int[] totalCuts = new int[cutsLen + 2];
        int totalLen = totalCuts.length;
        totalCuts[0] = 0;
        totalCuts[totalLen - 1] = n;
        for (int i = 0; i < cutsLen; ++i) {
            totalCuts[i + 1] = cuts[i];
        }
        Arrays.sort(totalCuts);
        int len = cuts.length;

        int[][] memo= new int[totalLen][totalLen];

        for (int i = totalLen - 1; i >= 0; --i) {
            for (int j = i + 1; j < totalLen; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    int cost = memo[i][k] + memo[k][j] + totalCuts[j] - totalCuts[i];
                    memo[i][j] = Math.min((memo[i][j] == 0) ? Integer.MAX_VALUE : memo[i][j], cost);
                }
            }
        }
        return memo[0][totalLen - 1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};

        new MinCost2CutStick().minCost(n, cuts);
    }
}
