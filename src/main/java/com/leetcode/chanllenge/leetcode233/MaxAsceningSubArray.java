package com.leetcode.chanllenge.leetcode233;

public class MaxAsceningSubArray {
    public int maxAscendingSum(int[] nums) {
        final int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int curr = 0;

        int preSum = nums[curr];
        int max =preSum;

        while (curr < len - 1) {
            ++curr;
            if (nums[curr] > nums[curr - 1]) {
                preSum += nums[curr];
                max = Math.max(max, preSum);
            } else {
                preSum = nums[curr];
                max = Math.max(max, preSum);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        new MaxAsceningSubArray().maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12});
    }
}
