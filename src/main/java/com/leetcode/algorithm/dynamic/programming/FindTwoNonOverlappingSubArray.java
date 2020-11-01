package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode：1477
 */
public class FindTwoNonOverlappingSubArray {
    public int slidingWindows(int[] arr, int target) {
        int len = arr.length;

        int result = Integer.MAX_VALUE;

        int sum = 0;
        int leftIndex = 0;
        int[] memo = new int[len];
        Arrays.fill(memo, Integer.MAX_VALUE);

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; ++i) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[leftIndex++];
            }


            if (sum == target) {
                if (leftIndex > 0 && memo[leftIndex - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, memo[leftIndex - 1] + i - leftIndex + 1);
                }
                minLen = Math.min(minLen, i - leftIndex + 1);
            }
            memo[i] = minLen;
        }
        return result == Integer.MAX_VALUE ? -1 : result;


    }


    public int minSumOfLengths(int[] arr, int target) {
        int len = arr.length;

        Map<Integer, Integer> cache = new HashMap<>();

        cache.put(0, -1);

        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += arr[i];
            cache.put(sum, i);
        }

        int leftSize = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += arr[i];

            if (cache.containsKey(sum - target)) {
                leftSize = Math.min(leftSize, i - cache.get(sum - target));
            }

            if (cache.containsKey(sum + target) && leftSize < Integer.MAX_VALUE) {
                minLen = Math.min(minLen, leftSize + cache.get(sum + target) - i );
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }



}