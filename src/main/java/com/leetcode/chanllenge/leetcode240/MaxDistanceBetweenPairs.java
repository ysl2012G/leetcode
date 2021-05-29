package com.leetcode.chanllenge.leetcode240;

public class MaxDistanceBetweenPairs {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int max = 0;
        while (i < nums2.length) {
            max = Math.max(max, binarySearch(nums2, i, nums1[i]) - i);
            ++i;
        }
        return max;
    }

    private int binarySearch(int[] nums2, int startIndex, int target) {
        if (nums2[startIndex] < target) {
            return 0;
        }
        int left = startIndex;
        int right = nums2.length;
        while (left < right) {
            final int mid = left + (right - left) / 2;
            if (nums2[mid] >= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        final int[] nums1 = {9819,9508,7398,7347,6337,5756,5493,5446,5123,3215,1597,774,368,313};
        final int[] nums2 = {9933,9813,9770,9697,9514,9490,9441,9439,8939,8754,8665,8560};

        System.out.println(new MaxDistanceBetweenPairs().maxDistance(nums1, nums2));
    }
}
