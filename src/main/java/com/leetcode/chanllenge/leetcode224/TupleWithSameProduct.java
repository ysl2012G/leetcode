package com.leetcode.chanllenge.leetcode224;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {

    public int tupleSameProduct(int[] nums) {
        final Map<Integer, Integer> cache = new HashMap<>();
        final int len = nums.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                final int product = nums[i] * nums[j];
                cache.merge(product, 1, (v1, v2) -> v1 + 1);
            }
        }

        int count = 0;
        for (int appreance: cache.values()) {
            if (appreance == 1) {
                continue;
            }
            count += appreance * (appreance - 1) / 2;
        }
        return count * 8;
    }

    public static void main(String[] args) {
        new TupleWithSameProduct().tupleSameProduct(new int[] {1, 2, 4, 5,10});
    }
}
