package com.leetcode.chanllenge.leetcode216;

public class Ways2MakeFairArray {
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        if (len == 2) {
            return 0;
        }

        final int[] leftodds = new int[len + 1];
        final int[] leftEvens = new int[len + 1];
        final int[] rightOdds = new int[len + 1];
        final int[] rightEvens = new int[len + 1];

        int totalSum = 0;
        for (int i = 1; i <= len; ++i) {
            leftEvens[i] = leftEvens[i - 1];
            rightEvens[i] = rightEvens[i -1];
            leftodds[i] = leftodds[i - 1];
            rightOdds[i] = rightOdds[i - 1];

            final int rightIndex = len - i;
            if (i % 2 == 0) {
                leftEvens[i] += nums[i - 1];
                rightEvens[i] += nums[rightIndex];
            } else {
                leftodds[i] += nums[i - 1];
                rightOdds[i] += nums[rightIndex];
            }
            totalSum += nums[i - 1];
        }

        int res = 0;
        for (int i = 0; i < len; ++i) {
            final int remainSum = totalSum - nums[i];
            if (remainSum % 2 != 0) {
                continue;
            }
            final int evenSumFromRight;

            final boolean unchanged = ((len - 1 - i) % 2) == ((i + 1) % 2);
            if (unchanged) {
                evenSumFromRight = rightEvens[len - 1 - i];
            } else {
                evenSumFromRight = rightOdds[len - 1 - i];
            }
            final int evenSum = leftEvens[i] + evenSumFromRight;
            if (remainSum / 2 == evenSum ) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        final int[] nums = {4,1,1,2,5,1,5,4};
        System.out.println(new Ways2MakeFairArray().waysToMakeFair(nums));
    }
}
