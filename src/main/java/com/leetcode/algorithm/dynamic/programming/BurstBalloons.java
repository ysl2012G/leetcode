package com.leetcode.algorithm.dynamic.programming;

/**
 * leetcode: 312
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] totalNums = new int[len + 2];
        int totalLen = totalNums.length;
        totalNums[0] = 1;
        totalNums[len + 1] = 1;
        for (int i = 0; i < len; ++i) {
            totalNums[i + 1] = nums[i];
        }

        int[][] memo = new int[totalLen][totalLen];

        for (int i = len; i >= 1; --i) {
            for (int j = i; j <= len; ++j) {
                for (int k = i; k <= j; ++k) {
                    int cost = memo[i][k - 1] + memo[k + 1][j] + totalNums[i - 1] * totalNums[k] * totalNums[j + 1];
                    memo[i][j] = Math.max(memo[i][j], cost);
                }
            }
        }
        return memo[1][len];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        new BurstBalloons().maxCoins(nums);
    }

}
