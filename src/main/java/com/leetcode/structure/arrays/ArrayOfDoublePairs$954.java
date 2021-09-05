package com.leetcode.structure.arrays;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoublePairs$954 {
    public boolean canReorderDoubled(int[] arr) {
        final Map<Integer, Integer> cache = new TreeMap<>();
        for (int num : arr) {
            cache.merge(num, 1, (oldVal, newVal) -> oldVal + 1);
        }

        while (!cache.isEmpty()) {
            final int val = cache.keySet().iterator().next();
            final int count = cache.remove(val);
            if (val == 0 ) {
                if (count % 2 != 0) {
                    return false;
                }
                continue;
            }

            if (val < 0 && val % 2 != 0) {
                return false;
            }

            final int doubleVal = val > 0 ? val * 2 : val / 2;
            final Integer doubleValCount = cache.remove(doubleVal);
            if (doubleValCount == null || count > doubleValCount) {
                return false;
            }
            final int diff = doubleValCount - count;
            if (diff != 0) {
                cache.put(doubleVal, doubleValCount - count);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final int[] arr = {4,4,8,8,8,8,2,2,16,16,1,32};
        new ArrayOfDoublePairs$954().canReorderDoubled(arr);
    }
}
