package com.leetcode.structure.repractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final int len = nums.length;
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1;
            int hi = len - 1;

            while (lo < hi) {
                final int curr = nums[i] + nums[lo] + nums[hi];
                if (curr == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    ++lo;
                    while (lo < len && nums[lo] == nums[lo - 1]) {
                        ++lo;
                    }
                    --hi;
                    while (hi > lo && nums[hi] == nums[hi + 1]) {
                        --hi;
                    }
                } else if (curr < 0) {
                    ++lo;
                    while (lo < len && nums[lo] == nums[lo - 1]) {
                        ++lo;
                    }
                } else {
                    --hi;
                    while (hi > lo && nums[hi] == nums[hi + 1]) {
                        --hi;
                    }
                }
            }
        }
        return res;
    }
}
