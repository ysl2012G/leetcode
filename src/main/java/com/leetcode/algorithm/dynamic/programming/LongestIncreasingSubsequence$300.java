package com.leetcode.algorithm.dynamic.programming;

public class LongestIncreasingSubsequence$300 {
    public int lengthOfLIS(int[] nums) {
        final int len = nums.length;
        final int[] memo = new int[len];
        memo[0] = 1;
        int max  = 1;
        for (int i = 1; i < len; ++i) {
            memo[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            max = Math.max(max, memo[i]);
        }
        return max;
    }

    public int lengthOfLISByBinarySearch(int[] nums) {
        final int len = nums.length;
        final int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int size = 1;
        for (int i = 1; i < len; ++i) {
            final int num = nums[i];
            if (num < tails[0]) {
                tails[0] = num;
            } else if (num > tails[size - 1]) {
                tails[size] = num;
                ++size;
            } else {
                // binary search
                int lo = 0;
                int hi = size;
                while (lo < hi) {
                    final int mid = lo + (hi - lo) / 2;
                    if (tails[mid] < num) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                tails[lo] = num;
            }
        }

        return size;
    }

    public static void main(String[] args) {
		final int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		new LongestIncreasingSubsequence$300().lengthOfLIS(nums);
    }
}
