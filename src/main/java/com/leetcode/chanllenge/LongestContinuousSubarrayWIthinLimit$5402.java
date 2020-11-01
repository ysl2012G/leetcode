package com.leetcode.chanllenge;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class LongestContinuousSubarrayWIthinLimit$5402 {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Integer, Integer> caches = new HashMap<>();

        SortedSet<Integer> values = new TreeSet<>();
        while (right < len && left < len) {
            caches.put(nums[right], right);
            values.add(nums[right]);
            int min = values.first();
            int max = values.last();
            if (max - min <= limit) {
                count = Math.max(count, right - left + 1);
                right ++;
            } else {
                int lastPos = caches.get(nums[left]);
                if (lastPos == left) {
                    values.remove(nums[left]);
                    caches.remove(nums[left]);
                }

                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;
        new LongestContinuousSubarrayWIthinLimit$5402().longestSubarray(nums, limit);
    }
}
