package com.leetcode.chanllenge.leetcode218;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        int num = 0;
        while (left < right) {
            final int sum = nums[left] + nums[right];
            if (sum == k) {
                ++left;
                --right;
                ++num;
            } else if (sum < k) {
                ++left;
            } else if (sum > k) {
                --right;
            }
        }
        return num;
    }
}
