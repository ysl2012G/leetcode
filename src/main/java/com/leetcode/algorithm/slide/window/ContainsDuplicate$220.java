package com.leetcode.algorithm.slide.window;

import java.util.TreeSet;

public class ContainsDuplicate$220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 0 || t < 0) {
            return false;
        }
        int len = nums.length;
        TreeSet<Integer> valSets = new TreeSet<>();

        for (int i = 0; i < len; i++){
            int val = nums[i];
            Integer floorVal = valSets.floor(val);
            Integer ceilVal = valSets.ceiling(val);
            if (floorVal != null && val - floorVal <= t) {
                return true;
            }
            if (ceilVal != null && ceilVal - val <= t) {
                return true;
            }
            valSets.add(nums[i]);
            if (i >= k) {
                valSets.remove(nums[i - k]);
            }
        }
        return false;
    }
}
