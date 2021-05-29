package com.leetcode.chanllenge.leetcode217;

import java.util.Deque;
import java.util.LinkedList;

public class FindTheMostCompetitiveSubSequence {
    public int[] mostCompetitive(int[] nums, int k) {
        final Deque<Integer> deque = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            while (!deque.isEmpty() && nums[i] < deque.peek() && deque.size() + len - i > k) {
                deque.pop();
            }
            if (deque.size() < k) {
                deque.push(nums[i]);
            }
        }

        final int[] res = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            res[i] = deque.pop();
        }
        return res;
    }


}
