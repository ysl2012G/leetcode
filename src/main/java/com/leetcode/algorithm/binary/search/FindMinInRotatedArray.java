package com.leetcode.algorithm.binary.search;

public class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo ) >> 1);
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                --hi;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int res = new FindMinInRotatedArray().findMin(new int[] {3,1,3});
        System.out.println(res);
    }
}
