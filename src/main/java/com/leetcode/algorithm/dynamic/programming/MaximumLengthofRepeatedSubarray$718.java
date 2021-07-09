package com.leetcode.algorithm.dynamic.programming;

public class MaximumLengthofRepeatedSubarray$718 {
    public int findLength(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;
        final int[] memo = new int[len2 + 1];

        int maxLen = 0;
        for (int i = 0; i < len1; ++i) {
            for (int j = len2 - 1; j >= 0; --j) {
                memo[j + 1] = nums1[i] == nums2[j] ? memo[j] + 1 : 0;
                maxLen = Math.max(memo[j + 1], maxLen);
            }
        }

        return maxLen;
    }

}
