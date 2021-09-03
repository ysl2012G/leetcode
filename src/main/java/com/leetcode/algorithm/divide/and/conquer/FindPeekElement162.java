package com.leetcode.algorithm.divide.and.conquer;

import java.util.stream.IntStream;

public class FindPeekElement162 {

    public int findPeakElement(int[] nums) {
        final int len = nums.length;
        final int[] auxi = IntStream.range(0, len).toArray();

        int lastIndex = len - 1;
        while (lastIndex != 0) {
            for (int i = 0; i <= (lastIndex - 1) / 2; ++i) {
                final int leftIndex = auxi[i * 2];
                final int rightIndex = auxi[i * 2 + 1];
                auxi[i] = nums[leftIndex] > nums[rightIndex] ? leftIndex : rightIndex;
            }

            if (lastIndex % 2 == 0) {
                auxi[lastIndex / 2] = auxi[lastIndex];
            }
            lastIndex /= 2;
        }

        return auxi[lastIndex];
    }

    public static void main(String[] args) {
        final int[] nums = {1, 2, 3, 1};
        new FindPeekElement162().findPeakElement(nums);
    }
}
