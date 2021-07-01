package com.leetcode.algorithm.bfs;

public class MaxConsecutiveOnes$1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0; int curr = 0;
        int count = 0;
        int res = k;
        for (; curr < nums.length; ++curr) {
            if (nums[curr] == 0) { ++count; }
            while (count > k) {
                if (nums[left++] == 0) {
                    --count;
                }
            }
            res = Math.max(res, curr - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
		final int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
		new MaxConsecutiveOnes$1004().longestOnes(nums, 2);

    }


}
