package com.leetcode.chanllenge.leetcode263;

public class CountNumberOfMaximalBitwiseORSubsets {

    private int ans;
    private int[] nums;
    private int max;
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        this.ans = 0;
        this.nums = nums;
        this.max = max;
        for (int i = 0; i < nums.length; ++i) {
            backtrack(i, nums[i]);
        }
        return ans;
    }

    private void backtrack(int index, int curr) {
        if (curr == max) {
            ++ans;
        }

        for (int i = index + 1; i < nums.length; ++i) {
            final int next = curr | nums[i];
            backtrack(i, next);
        }
    }



}
