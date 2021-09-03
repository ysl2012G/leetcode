package com.leetcode.algorithm.binary.search;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements$658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - k;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (x - arr[mid] > arr[mid + k] - x) { lo = mid + 1; }
            else { hi = mid; }
        }

        final List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) {
            res.add(arr[i + lo]);
        }
        return res;

//        return Collections.singletonList(arr).subList(lo, lo + k);
    }
}