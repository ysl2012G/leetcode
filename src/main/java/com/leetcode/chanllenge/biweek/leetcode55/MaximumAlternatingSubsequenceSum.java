package com.leetcode.chanllenge.biweek.leetcode55;

public class MaximumAlternatingSubsequenceSum {
    public long maxAlternatingSum(int[] nums) {
        int even = 0;
        int odd = 0;
        for (int num : nums) {
            even = Math.max(even, odd + num);
            odd = even - num;
        }
        return even;
    }
}
