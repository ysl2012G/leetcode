package com.leetcode.chanllenge.leetcode238;

import java.util.Arrays;

public class FreqOfTheMostFreqElements {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        long sum = 0;
        int res = 0;
        for (int j = 0; j < nums.length; ++j) {
            sum += nums[j];
            while (sum + k < (long) nums[j] * (j - i + 1)) {
                sum -= nums[i];
                i += 1;
            }
            res = Math.max(res, j - i  + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        final int[] nums = {1, 2, 4};
        final int k = 5;
        new FreqOfTheMostFreqElements().maxFrequency(nums, k);
    }
}
