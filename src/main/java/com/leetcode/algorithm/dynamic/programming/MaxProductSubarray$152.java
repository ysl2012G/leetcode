package com.leetcode.algorithm.dynamic.programming;

public class MaxProductSubarray$152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        int len = nums.length;
        for (int i = 1; i < len; i ++) {
            int num = nums[i];
            if (num >= 0) {
                max = Math.max(num, max * num);
                min = Math.min(num, min * num);
            } else {
                int tempMax = max;
                max = Math.max(num, min * num);
                min = Math.min(num, tempMax * num);
            }
            res = Math.max(res, max);
        }
        return res;

    }
}
