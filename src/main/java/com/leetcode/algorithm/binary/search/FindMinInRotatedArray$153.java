package com.leetcode.algorithm.binary.search;

public class FindMinInRotatedArray$153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }

        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int res = new FindMinInRotatedArray$153().findMin(new int[] {2, 1});
        System.out.println(res);
    }
}
