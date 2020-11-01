package com.leetcode.algorithm.binary.search;

public class SearchInRotatedArray$33 {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int lo = 0;
		int hi = nums.length - 1;
		int mid;
		while (lo <= hi) {
		    mid  = (lo + hi) >> 1;
			int loVal = nums[lo];
			int midVal = nums[mid];
			int highVal = nums[hi];
			if (midVal == target) {
				return mid;
			} else if (midVal < highVal) {
				if (midVal < target && highVal >= target) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			} else {
				if (midVal > target && loVal <= target) {
					hi = mid - 1;
				} else {
                    lo = mid + 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		new SearchInRotatedArray$33().search(nums, 0);
	}
}
