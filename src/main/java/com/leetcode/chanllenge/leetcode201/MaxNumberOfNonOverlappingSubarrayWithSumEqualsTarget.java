package com.leetcode.chanllenge.leetcode201;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfNonOverlappingSubarrayWithSumEqualsTarget {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        // key: cummulative sum; key: index
        cache.put(0, -1);

        int len = nums.length;

        int preIndex = -1;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];

            if (cache.containsKey(sum - target) && cache.get(sum - target) >= preIndex) {
                ++count;
                preIndex = i;
            }
            cache.put(sum, i);
        }
        return count;
    }

    public static void main(String[] args) {
        final int[] nums = {-5, 5, -4, 5, 4};
        int target = 5;
        int res = new MaxNumberOfNonOverlappingSubarrayWithSumEqualsTarget().maxNonOverlapping(nums, target);
        System.out.println(res);
    }
}