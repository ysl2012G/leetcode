package com.leetcode.chanllenge.leetcode241;

public class SumOfAllSubsetXORTotals {
    private int[] nums;
    public int subsetXORSum(int[] nums) {
        final int LEN = nums.length;
        this.nums = nums;
        int res = 0;
        for (int step = 1; step <= LEN; ++step) {
            res += backTrack(0, 0, step);
        }

        return res;
    }

    private int backTrack(int current, int index, int remain) {
        int res = 0;
        for (int i = index; i <= nums.length - remain; ++i) {
            final int xor = current ^ nums[i];
            if (remain == 1) {
                res += xor;
            } else {
                res += backTrack(xor, i + 1, remain - 1);
            }
        }
        return res;
    }

    private int sumUseBit(int[] nums) {
        final int LEN = nums.length;
        final int limit = 1 << LEN;
        int res = 0;
        for (int i = 0; i < limit; ++i) {
            int current = 0;
            for (int j = 0; j < LEN; ++j) {
                if (((i >> j) & 1) != 0) {
                    current ^= nums[j];
                }
            }
            res += current;
        }
        return res;
    }

    public static void main(String[] args) {
        final int[] nums = {3, 4, 5, 6, 7, 8};
//        final int[] nums = {5, 1, 6};
        System.out.println(new SumOfAllSubsetXORTotals().subsetXORSum(nums));
    }
}
