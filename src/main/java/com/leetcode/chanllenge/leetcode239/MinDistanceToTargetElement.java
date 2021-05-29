package com.leetcode.chanllenge.leetcode239;

public class MinDistanceToTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        final int LEN = nums.length;

        if (nums[start] == target) {
            return 0;
        }

        int step = 1;
        while (start + step < LEN || start - step >= 0) {
            final int left = start - step >= 0 ? nums[start - step] : -1;
            final int right = start + step < LEN ? nums[start + step] : -1;

            if (left == target || right == target) {
                return step;
            }
            ++step;
        }
        return -1;
    }
}
