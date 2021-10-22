package com.leetcode.structure.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElement$496$503 {
    /**
     * leetcode 496
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> cache = new HashMap<>();

        final Deque<Integer> deque = new LinkedList<>();
        for (int num : nums2) {
            while (!deque.isEmpty() && deque.peek() < num) {
                cache.put(deque.pop(), num);
            }
            deque.push(num);
        }

        final int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            ans[i] = cache.getOrDefault(nums1[i], -1);
        }
        return ans;
    }


    /**
     * leetcode 503
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        final Map<Integer, Integer> cache = new HashMap<>();

        final Deque<Integer> deque = new LinkedList<>();
        final int len = nums.length;

        final int[] ans = new int[len];
        Arrays.fill(ans, -1);

        for (int i = 0; i < len * 2; ++i) {
            final int val = nums[i % len];
            while (!deque.isEmpty() && nums[deque.peek()] < val) {
                ans[deque.pop()] = val;
            }
            if (i < len) {
                deque.push(i);
            }
        }

        return ans;
    }
}
