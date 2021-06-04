package com.leetcode.structure.arrays;

import java.util.Arrays;

public class FirstMissingPositive$41 {
    public int firstMissingPositive(int[] nums) {
        final int LEN = nums.length;
        final int[] auxi = new int[LEN];
        Arrays.fill(auxi, -1);
        for (int num : nums) {
            if (num <= 0 || num > LEN ) {
                continue;
            }
            ++auxi[num - 1];
        }

        for (int i = 0; i < LEN; ++i) {
            if (auxi[i] < 0) {
                return i + 1;
            }
        }
        return LEN + 1;
    }
}
