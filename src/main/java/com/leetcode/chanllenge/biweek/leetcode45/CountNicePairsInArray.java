package com.leetcode.chanllenge.biweek.leetcode45;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInArray {
    public int countNicePairs(int[] nums) {
        final Map<Integer, Integer> counter = new HashMap<>();

        final int DIVIDEND = (int)(1e9 + 7);
        int res = 0;
        for (int num : nums) {
            final int diff = num - rev(num);

            final int current = counter.merge(diff, 1, (oldV, newV) -> oldV + 1);
            res = (res + current - 1) % DIVIDEND;
        }
        return res;
    }

    private int rev(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + (num % 10);
            num /= 10;
        }
        return res;
    }
}
