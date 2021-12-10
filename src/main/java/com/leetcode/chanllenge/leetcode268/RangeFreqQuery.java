package com.leetcode.chanllenge.leetcode268;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {
    private Map<Integer, List<Integer>> cache;

    public RangeFreqQuery(int[] arr) {
        this.cache = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!cache.containsKey(arr[i])) {
                cache.put(arr[i], new ArrayList<>());
            }
            cache.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        final List<Integer> list = cache.get(value);
        if (list == null) {
            return 0;
        }
        final int len = list.size();
        final int leftIndex = binarySearch(list, 0, left);
        if (leftIndex >= len || list.get(leftIndex) > right) {
            return 0;
        }

        final int rightIndex = binarySearch(list, leftIndex + 1, right + 1);
        return rightIndex - leftIndex;
    }

    private int binarySearch(List<Integer> list, int lo, int target) {
        int hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        final int[] arr = {1,1,1,2,2};
        final RangeFreqQuery solution = new RangeFreqQuery(arr);
        solution.query(0, 1, 2);
    }
}
