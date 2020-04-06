package com.leetcode.structure.arrays;

public class MaxSubarray$53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            res = Math.max(curSum, res);
        }
        return res;
    }

    public int maxSubDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }

    public int maxSubDivide(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0 , nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >> 1;
        int leftMax = helper(nums, left, mid - 1);
        int rightMax = helper(nums, mid + 1, right);
        int middleMax = nums[mid];
        int temp = middleMax;
        for (int i = mid - 1; i >= left; i--) {
            temp += nums[i];
            middleMax = Math.max(temp, middleMax);
        }
        temp = middleMax;
        for (int i = mid + 1; i <= right; i++) {
            temp += nums[i];
            middleMax = Math.max(temp, middleMax);
        }
        return Math.max(Math.max(leftMax, rightMax), middleMax);
    }
}
