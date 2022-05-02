package com.leetcode.algorithm.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        final int len = nums.length;

        // the length of largest divisible subset end at element i;
        final int[] memo = new int[len];
        // prev index before element i in the largest divisible subset end at elemnt i, -1 means no prev index;
        final int[] prev = new int[len];

        Arrays.sort(nums);

        int max = 0;
        int index = -1;
        for (int i = 0; i < len; ++i) {
            memo[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0 && memo[j] + 1 > memo[i]) {
                    memo[i] = memo[j] + 1;
                    prev[i] = j;
                }
            }
            if (memo[i] > max) {
                max = memo[i];
                index = i;
            }
        }
        final List<Integer> res = new ArrayList<>();
        while (index != -1 ) {
            res.add(nums[index]);
            index = prev[index];
        }
        return res;
    }
}
