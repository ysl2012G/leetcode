package com.leetcode.algorithm.dynamic.programming;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {

        int currMax = 0;
        int currMin = 0;
        int maxSum = nums[0];
        int minSum = nums[0];

        int totalSum = 0;
        for (int num : nums) {
            // dp[i] = max(nums[i], dp[i - 1] + nums[i])
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(currMax, maxSum);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }

        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }
}
