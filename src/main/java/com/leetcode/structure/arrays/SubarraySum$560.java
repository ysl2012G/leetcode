package com.leetcode.structure.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum$560 {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // key: sum, value: appear time
        Map<Integer, Integer> store = new HashMap<>();
        store.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += nums[i];
            res += store.getOrDefault(sum - k, 0);
            store.merge(sum,1, (oldVal, newVal) -> oldVal + 1);
        }
        return res;
    }
}
