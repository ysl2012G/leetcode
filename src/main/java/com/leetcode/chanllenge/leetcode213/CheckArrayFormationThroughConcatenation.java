package com.leetcode.chanllenge.leetcode213;

import java.util.HashMap;
import java.util.Map;

/**
 * create by shuanglin on 2020/11/1
 */
public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        final Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            cache.put(arr[i], i);
        }


        for (int[] piece : pieces) {
            Integer previousIndex = null;
            for (int i = 0; i < piece.length; ++i) {
                final Integer index = cache.get(piece[i]);
                if (index == null) {
                    return false;
                }
                if (previousIndex != null && index != previousIndex + 1) {
                    return false;
                }
                previousIndex = index;
            }
        }

        return true;
    }
}
