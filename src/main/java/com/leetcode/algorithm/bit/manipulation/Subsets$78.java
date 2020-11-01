package com.leetcode.algorithm.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets$78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) { return null; }
        List<List<Integer>> subsets = new ArrayList<>();

        int len = nums.length;
        int subsetSize = (int) Math.pow(2, len);
        for (int i = 0; i < subsetSize; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0 ; j < len; j++) {
                int bitIndex = (int) Math.pow(2, j);
                if ((i & bitIndex) > 0) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
