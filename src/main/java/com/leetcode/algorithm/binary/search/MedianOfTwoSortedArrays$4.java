package com.leetcode.algorithm.binary.search;

public class MedianOfTwoSortedArrays$4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if (len1 > len2) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			len1 = nums1.length;
			len2 = nums2.length;
		}
		int lo = 0;
		int hi = nums1.length;
		int pos1 = 0;
		int pos2 = 0;



		while (lo <= hi) {
			pos1 = (lo + hi) >> 1;
			pos2 = ((len1 + len2 + 1) >> 1) - pos1;

			if (pos1 > lo && nums1[pos1 -1] > nums2[pos2]) {
				hi = pos1 - 1 ;
			} else if (pos1 < hi && nums2[pos2 -1] > nums1[pos1]) {
				lo = pos1 + 1;
			} else {
				int maxLeft = 0;
				if (pos1 ==0) {
					maxLeft = nums2[pos2 - 1];
				} else if (pos2 == 0) {
					maxLeft = nums1[pos1 - 1];
				} else {
					maxLeft = Math.max(nums1[pos1 - 1], nums2[pos2 - 1]);
				}
				if ((len1 + len2) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (pos1 == len1) {
					minRight = nums2[pos2];
				} else if (pos2 == len2) {
					minRight = nums1[pos1];
				} else {
					minRight = Math.min(nums1[pos1], nums2[pos2]);
				}
				return (minRight + maxLeft) / 2d;
			}
		}
		return 0d;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.println(new MedianOfTwoSortedArrays$4().findMedianSortedArrays(nums1,nums2));
	}

}
