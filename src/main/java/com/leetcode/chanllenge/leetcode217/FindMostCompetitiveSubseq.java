package com.leetcode.chanllenge.leetcode217;

import java.util.Arrays;

public class FindMostCompetitiveSubseq {
    public int[] mostCompetitive(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        return null;
    }

    public static void main(String[] args) {
        final int[] nums = {2,4,3,3,5,4,9,6};
        final int[] result = new FindMostCompetitiveSubseq().mostCompetitive(nums, 4);
        Arrays.stream(result).forEach(System.out::println);
    }
}
