package com.leetcode.chanllenge.leetcode215;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimizeOps2ReduceX2Zero {
    public int minOperations(int[] nums, int x) {
        final int totalSum = Arrays.stream(nums).sum();
        // <total sum, index>
        final Map<Integer, Integer> prefixSum = new HashMap<>();
        // initilization: total sum = 0; index = -1
        prefixSum.put(0, -1);

        int sum = 0;
        int subLen = -1;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            prefixSum.putIfAbsent(sum, i);
            int target = totalSum - x;
            Integer previousIndex = prefixSum.get(sum - target);
            if (previousIndex != null) {
                subLen = Math.max(subLen, i - previousIndex);
            }
        }
        return subLen == -1 ? subLen : nums.length - subLen;
    }
}
