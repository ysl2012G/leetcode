package com.leetcode.chanllenge.leetcode217;

import java.util.Arrays;

public class MinimumMoves2MakeArrayComplement {
    public int minMoves(int[] nums, int limit) {
        final int[] memo = new int[limit * 2 + 2];
        Arrays.fill(memo, 0);
        final int len = nums.length;
        for (int i = 0; i < len / 2; ++i) {
            final int left = nums[i];
            final int right = nums[len - 1 - i];

            --memo[Math.min(left, right) + 1];
            --memo[left + right];
            ++memo[left + right + 1];
            ++memo[Math.max(left, right) + limit + 1];
        }

        int res = len;
        int current = len;
        for (int move : memo) {
            current += move;
            res = Math.min(res, current);
        }

        return res;
    }
}
