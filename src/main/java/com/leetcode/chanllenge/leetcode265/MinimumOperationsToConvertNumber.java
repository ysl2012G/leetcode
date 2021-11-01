package com.leetcode.chanllenge.leetcode265;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumOperationsToConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        final Set<Integer> cache = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int op = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();


            for (int i = 0; i < size; ++i) {
                final int curr = queue.poll();
                if (curr == goal) {
                    return op;
                }
                if (curr < 0 || curr > 1000 || !cache.add(curr)) {
                    continue;
                }


                for (int num : nums) {
                    queue.add(curr + num);
                    queue.add(curr - num);
                    queue.add(curr ^ num);
                }
            }

            ++op;
        }

        return -1;
    }

    @Test
    public void test() {
        final int[] nums = {2, 4, 12};
        final MinimumOperationsToConvertNumber solution = new MinimumOperationsToConvertNumber();
        Assertions.assertEquals(2, solution.minimumOperations(nums, 2, 12));

    }
}
