package com.leetcode.algorithm.dfs;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayNesting$565 {
    private boolean[] marked;

    public int arrayNesting(int[] nums) {
        int count = 0;
        this.marked = new boolean[nums.length];
        for (int i = 0; i < nums.length; ++i) {
             count = Math.max(count, dfs(new HashSet<>(), i, nums));
        }
        return count;
    }

    private int dfs(Set<Integer> vals, int index, int[] nums) {
        if (index >= nums.length || marked[index]) {
            return vals.size();
        }

        final int val = nums[index];
        if (!vals.add(val)) {
            return vals.size();
        }
        marked[index] = true;
        return dfs(vals, val, nums);
    }

    @Test
    public void test() {
        final ArrayNesting$565 solution = new ArrayNesting$565();
        final int[] nums = {0, 2, 1};
        assertEquals(2, solution.arrayNesting(nums));
    }
}
