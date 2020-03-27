package com.leetcode.algorithm.binary.search;

import java.util.Arrays;

public class FindFirstLastElementInSortedArray$34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0 ) {
            return new int[] {-1, -1};
        }
        return new int[] {findTarget(nums, target, true), findTarget(nums, target, false)};
    }


    private int findTarget(int nums[], int target, boolean isMinIndex) {
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        int mid = (lo + hi) >> 1;
        int res = -1;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            int val = nums[mid];
            if (val < target) {
                lo = mid + 1;
            } else if (val > target) {
                hi = mid -1;
            } else {
                res = mid;
                if (isMinIndex) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = new FindFirstLastElementInSortedArray$34().searchRange(nums, 8);
    }

}
