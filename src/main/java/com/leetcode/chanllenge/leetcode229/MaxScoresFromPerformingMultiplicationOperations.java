package com.leetcode.chanllenge.leetcode229;

public class MaxScoresFromPerformingMultiplicationOperations {

    private int[][] memo;
    private int numsLen;
    private int multiLen;
    private boolean[][] marked;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.numsLen = nums.length;
        this.multiLen = multipliers.length;
        this.memo = new int[multiLen][multiLen];
        this.marked = new boolean[multiLen][multiLen];

        return helper(0, numsLen - 1, nums, multipliers);
    }


    private int helper(int i, int j, int[] nums, int[] multiplier) {
        int step = i + numsLen - 1 - j;
        if (step == multiLen) {
            return 0;
        }
        if (marked[i][step]) {
            return memo[i][step];
        }

        int leftPicked = nums[i] * multiplier[step] + helper(i + 1, j , nums, multiplier);
        int rightPicked = nums[j] * multiplier[step] + helper(i, j - 1, nums, multiplier);
        marked[i][step] = true;
        memo[i][step] = Math.max(leftPicked, rightPicked);
        return memo[i][step];
    }

    public static void main(String[] args) {
        final int[] nums = {1, 2, 3};
        final int[] multipliers = {3, 2, 1};
        new MaxScoresFromPerformingMultiplicationOperations().maximumScore(nums, multipliers);
    }


}
