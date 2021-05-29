package com.leetcode.chanllenge.leetcode240;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSubarrayMinProduct {
    public int maxSumMinProduct(int[] nums) {
        final int LEN = nums.length;

        final Deque<Integer> stack = new LinkedList<>();
        final int[] leftBound = new int[LEN];
        for (int i = 0; i < LEN; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            leftBound[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        final int[] rightBound = new int[LEN];
        for (int i = LEN - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            rightBound[i] = stack.isEmpty() ? LEN - 1 : stack.peek() - 1;
            stack.push(i);
        }

        final long[] preSum = new long[LEN + 1];
        for (int i = 0; i < LEN; ++i) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        long max = 0;
        for (int i = 0; i < LEN; ++i) {
            max = Math.max(max, (preSum[rightBound[i] + 1] - preSum[leftBound[i]]) * nums[i]);
        }

        return (int) (max % 1000_000_007);
    }

    public static void main(String[] args) {
        final int[] nums = {1, 2, 3, 2};
        new MaxSubarrayMinProduct().maxSumMinProduct(nums);
    }
}
