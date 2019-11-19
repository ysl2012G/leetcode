package com.leetcode.algorithm.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum$15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0 ; i < len - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int hi = len -1;
            int target = -nums[i];
            while (low < hi) {
                if (nums[i] + nums[low] + nums[hi] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[hi])));
                    low ++;
                    while (low < hi && nums[low -1] == nums[low])
                    low ++;
                } else if (nums[i] + nums[low] + nums[hi] < 0) {
                    low ++;
                } else {
                    hi --;
                }

            }
        }

        return res;
    }


}
