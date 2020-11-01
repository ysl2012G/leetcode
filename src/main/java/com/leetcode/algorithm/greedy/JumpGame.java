package com.leetcode.algorithm.greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxReach = 0;
        for (int i = 0; i < len; i++) {
            if (i > maxReach || maxReach >= len - 1) {
                break;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= len - 1;
    }
}
