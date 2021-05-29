package com.leetcode.chanllenge.leetcode231;

import java.util.Arrays;

public class MinElements2Add2FormGivenSum {
    public int minElements(int[] nums, int limit, int goal) {
        long currentSum = Arrays.stream(nums).mapToLong(i -> i).sum();
        final long diff = Math.abs(goal - currentSum);

        int res = (int) (diff / limit);

        return diff % limit == 0  ? res : res + 1;
    }

}
