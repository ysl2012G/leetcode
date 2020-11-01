package com.leetcode.chanllenge.leetcode200;

public class GetMaximumScore {



	public int maxSum(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		long accum1 = 0;
		long accum2 = 0;
		int index1 = 0;
		int index2 = 0;
		long sum = 0;
		while (index1 < len1 && index2 < len2) {
			if (nums1[index1] < nums2[index2]) {
				accum1 += nums1[index1++];
			} else if (nums1[index1] > nums2[index2]) {
				accum2 += nums2[index2++];
			} else {
				sum += Math.max(accum1, accum2) + nums1[index1];
				++index1;
				++index2;
				accum1 = 0;
				accum2 = 0;
			}
		}
		while (index1 < len1) {
		    accum1 += nums1[index1++];
        }
		while (index2 < len2) {
		    accum2 += nums2[index2++];
        }
		final long mod = (long) (1e9 + 7);
		sum = (sum + Math.max(accum1, accum2)) % mod;
        return (int) sum;
	}

}
