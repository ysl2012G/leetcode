package com.leetcode.algorithm.dynamic.programming;

public class NumberOfSubarraysWithBounded$795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int startIndex = 0;

        // numbers of subarrays end at nums[i];
        int memo = 0;

        for (int i = 0; i < nums.length; ++i) {
            final int num = nums[i];
            if (num >= left && num <= right) {
                memo = i - startIndex + 1;
                res += memo;
            } else if (num < left) {
                res += memo;
            } else {
                startIndex = i + 1;
                memo = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        final int[] nums = {2, 1, 4, 3};
        
        new NumberOfSubarraysWithBounded$795().numSubarrayBoundedMax(nums, 2, 3);
    }
}
