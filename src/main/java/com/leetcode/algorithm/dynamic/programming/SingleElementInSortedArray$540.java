package com.leetcode.algorithm.dynamic.programming;

public class SingleElementInSortedArray$540 {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;
            final int val = nums[mid];
            final int left = mid > 0 ? nums[mid - 1] : -1;
            final int right = mid < nums.length - 1? nums[mid + 1] : -1;
            if (val != left && val != right) {
                return val;
            }
            final int index = val == left ? mid - 1 : mid;
            if (index % 2 == 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return -1;
    }
}
