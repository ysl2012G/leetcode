package com.leetcode.chanllenge.biweek.leetcode53;

import java.util.Arrays;

public class MinimizeMaxPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length / 2; ++i) {
            res = Math.max(res, nums[i] + nums[nums.length - 1 - i]);
        }

        return res;
    }
}
