package com.leetcode.algorithm.two.pointer;

public class RemoveDuplicatesFromSortedArrays$26 {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0;

		int numsLen = nums.length;
		for (int right = 1; right < numsLen; right ++) {
		    if (nums[right] != nums[left]) {
		        nums[++left] = nums[right];
            }
        }
		return left + 1;
	}

	public static void main(String[] args) {
		new RemoveDuplicatesFromSortedArrays$26().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
	}
}
