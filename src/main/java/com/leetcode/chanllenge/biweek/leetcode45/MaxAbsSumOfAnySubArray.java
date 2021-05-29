package com.leetcode.chanllenge.biweek.leetcode45;

public class MaxAbsSumOfAnySubArray {
    public int maxAbsoluteSum(int[] nums) {
        int previousMax = 0;
        int previousMin = 0;

        int max = 0;
        int min = 0;
        for (int num : nums) {
            previousMax = Math.max(previousMax + num, num);
            previousMin = Math.min(previousMin + num, num);

            max = Math.max(previousMax, max);
            min = Math.min(previousMin, min);
        }
        return Math.max(max, Math.abs(min));
    }

    public static void main(String[] args) {
        final int[] nums = {2,-5,1,-4,3,-2};
        new MaxAbsSumOfAnySubArray().maxAbsoluteSum(nums);
    }
}
