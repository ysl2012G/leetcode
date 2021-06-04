package com.leetcode.algorithm.binary.search;

public class MedianOfTwoSortedArrays$4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            final int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        final int len1 = nums1.length;
        final int len2 = nums2.length;
        final int halfLen = (len1 + len2 + 1) / 2;

        int lo = 0;
        int hi = len1;


        while (lo < hi) {
            final int pos1 = lo + (hi - lo) / 2;
            final int pos2 = halfLen - pos1;

            if (pos1 < len1 && nums2[pos2 - 1] > nums1[pos1]) {
                lo = pos1 + 1;
            } else if (pos1 > 0 && nums1[pos1] > nums2[pos2]) {
                hi = pos1;
            } else {
                break;
            }
        }

        final int pos1 = lo + (hi - lo) / 2;
        final int pos2 = halfLen - pos1;
        final int maxOfLeft;
        if (pos1 == 0) {
            maxOfLeft = nums2[pos2 - 1];
        } else if (pos2 == 0) {
            maxOfLeft = nums1[pos1 - 1];
        } else {
            maxOfLeft = Math.max(nums1[pos1 - 1], nums2[pos2 - 1]);
        }

        if ((len1 + len2) % 2 == 1) {
            return maxOfLeft;
        }

        final int minOfRight;
        if (pos1 == len1) {
            minOfRight = nums2[pos2];
        } else if (pos2 == len2) {
            minOfRight = nums1[pos1];
        } else {
            minOfRight = Math.min(nums1[pos1], nums2[pos2]);
        }

        return (minOfRight + maxOfLeft) / 2d;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(new MedianOfTwoSortedArrays$4().findMedianSortedArrays(nums1,nums2));
	}

}
