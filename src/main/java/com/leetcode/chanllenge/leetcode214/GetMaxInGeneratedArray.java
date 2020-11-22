package com.leetcode.chanllenge.leetcode214;

public class GetMaxInGeneratedArray {
    public int getMaximumGenerated(int n) {
        final int[] nums = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        nums[0] = 0;
        nums[1] = 1;
        int max = nums[1];
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2];
            if (i % 2 != 0) {
                nums[i] += nums[ i / 2 + 1];
            }
            max = Math.max(nums[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new GetMaxInGeneratedArray().getMaximumGenerated(7));
    }
}
