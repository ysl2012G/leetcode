package com.leetcode.chanllenge.leetcode232;

public class MaxScoreOfGoodSubarray {

    public int maximumScore(int[] nums, int k ) {
        int maxScores = nums[k];

        int left = k;
        int right = k;
        int min = nums[k];

        while (left > 0 || right < nums.length -1 ) {
            if (left == 0) {
                ++right;
            } else if (right == nums.length - 1) {
                --left;
            } else if (nums[left - 1] > nums[right + 1]) {
                --left;
            } else {
                ++right;
            }
            min = Math.min(min, Math.min(nums[left], nums[right]));
            maxScores = Math.max(maxScores, min * (right - left + 1));
        }

        return maxScores;
    }

    public static void main(String[] args) {
        new MaxScoreOfGoodSubarray().maximumScore(new int[]{6569,9667,3148,7698,1622,2194,793,9041,1670,1872}, 5);
    }
}
