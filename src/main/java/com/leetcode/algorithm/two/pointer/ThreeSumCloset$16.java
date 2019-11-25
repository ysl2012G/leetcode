package com.leetcode.algorithm.two.pointer;

import java.util.Arrays;

public class ThreeSumCloset$16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int numsLen = nums.length;
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < numsLen - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int hi = numsLen - 1;
            while (low < hi) {
                int sum = nums[i] + nums[low] + nums[hi];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    low++;
                    int diff = target - sum;
                    if (delta > diff) {
                        delta = diff;
                        res = sum;
                        while (low < hi && nums[low] == nums[low - 1]) {
                            low++;
                        }
                    }
                } else {
                    hi--;
                    int diff = sum - target;
                    if (delta > diff) {
                        delta = diff;
                        res = sum;
                        while (low < hi && nums[hi] == nums[hi + 1]) {
                            hi--;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
		System.out.println(new ThreeSumCloset$16().threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }
}
