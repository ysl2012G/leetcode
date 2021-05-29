package com.leetcode.chanllenge.leetcode227;

public class CheckIfArrayIsSrotedAndRotated {
    public boolean check(int[] nums) {
        boolean rotated = false;
        int previous = nums[0];

        final int len = nums.length;
        int index = 0;
        while (++index < len) {
            if (nums[index] >= previous) {
                previous = nums[index];
            } else if (!rotated) {
                rotated =  true;
                previous = nums[index];
            } else {
                return false;
            }
        }

        if (rotated) {
            return previous <= nums[0];
        } else {
            return true;
        }
    }
}
