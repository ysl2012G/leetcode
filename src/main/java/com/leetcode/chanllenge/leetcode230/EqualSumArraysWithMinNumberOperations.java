package com.leetcode.chanllenge.leetcode230;

import java.util.Arrays;

public class EqualSumArraysWithMinNumberOperations {
    public int minOperations(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;

        if (len1 * 6 < len2 || len2 * 6 < len1) {
            return -1;
        }

        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        if (sum1 > sum2) {
            final int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            final int sum = sum1 ^ sum2;
            sum1 = sum ^ sum1;
            sum2 = sum ^ sum2;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = nums2.length - 1;
        int operations = 0;
        while (sum1 < sum2) {
            if (j < 0 || i < nums1.length && 6 - nums1[i] > nums2[j] - 1) {
                sum1 += 6 - nums1[i++];
            } else {
                sum2 -= nums2[j--] - 1;
            }
            ++operations;
        }

        return operations;
    }
}
