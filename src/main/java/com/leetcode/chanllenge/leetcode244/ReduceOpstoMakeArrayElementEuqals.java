package com.leetcode.chanllenge.leetcode244;

import java.util.Arrays;

public class ReduceOpstoMakeArrayElementEuqals {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];

        int step = 0;
        int counter = 1;
        int ops = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > min) {
                ops += step * counter;
                ++step;
                counter = 1;
                min = nums[i];
            } else {
                ++counter;
            }
        }
        ops += step * counter;
        return ops;
    }

    public static void main(String[] args) {
        final int[] nums = { 5, 1, 3};
        new ReduceOpstoMakeArrayElementEuqals().reductionOperations(nums);
    }
}
