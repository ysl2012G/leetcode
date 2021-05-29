package com.leetcode.chanllenge.leetcode235;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinAbsoluteSumDiff {
    private static final int DIVIDEND = (int) 1e9 + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int totalSumDiff = 0;

        final Map<Integer, Integer> cache = new HashMap<>();
        int maxDiff = 0;

        for (int i = 0; i < nums1.length; ++i) {
            final int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > maxDiff) {
                cache.clear();
                maxDiff = diff;
                cache.put(nums2[i], i);
            } else if (diff == maxDiff) {
                cache.put(nums2[i], i);
            }

            totalSumDiff += diff;
            totalSumDiff %= DIVIDEND;
        }

        if (totalSumDiff == 0) {
            return 0;
        }

        if (nums1.length == 1) {
            return totalSumDiff;
        }


        final int[] sorted = new int[nums1.length];
        System.arraycopy(nums1, 0, sorted, 0, nums1.length);

        Arrays.sort(sorted);
        int result = totalSumDiff;
        for (int index : cache.values()) {

            int minus = Math.abs(nums1[index] - nums2[index]) - findMinDiff(sorted, nums2[index]);

            minus = minus > 0 ? minus : 0;

            final int curr = totalSumDiff - minus % DIVIDEND;

            result = Math.min(result, curr);
        }

        return result;




    }

    private int findMinDiff(int[] sorted, int target) {
        int lo = 0;
        int hi = sorted.length;

        while (lo < hi) {
            int mid = lo + (hi - lo ) / 2;
            if (sorted[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        if (lo == sorted.length) {
            return Math.abs(sorted[lo - 1] - target);
        } else if (lo == 0) {
            return Math.abs(sorted[lo] - target);
        } else {
            return Math.min(Math.abs(sorted[lo - 1] - target), Math.abs(sorted[lo] - target));
        }
    }

    public static void main(String[] args) {
        final int[] nums1 = new int[100000];
        final int[] nums2 = new int[100000];

        Arrays.fill(nums1, 1);
        Arrays.fill(nums2, 100000);
        System.out.println(new MinAbsoluteSumDiff().minAbsoluteSumDiff(nums1, nums2));
    }
}
