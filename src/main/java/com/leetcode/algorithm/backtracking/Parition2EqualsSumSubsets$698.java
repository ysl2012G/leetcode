package com.leetcode.algorithm.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class Parition2EqualsSumSubsets$698 {
    private boolean[] visited;
    private int[] nums;
    private int subsetSum;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        final int sum = IntStream.of(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }

        this.subsetSum = sum / k;
        this.visited = new boolean[nums.length];
        this.nums = nums;
        return canPartition(0, k, subsetSum);
    }

    private boolean canPartition(int start, int remainSubsets, int target) {
        if (remainSubsets == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        } else if (target == 0) {
            return canPartition(0, remainSubsets - 1, subsetSum);
        }

        for (int i = start; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(i + 1, remainSubsets, target - nums[i])) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    @Test
    public void test() {
        final int[] nums = {2, 2, 2, 2, 3, 4, 5};
        final Parition2EqualsSumSubsets$698 solution = new Parition2EqualsSumSubsets$698();
        Assertions.assertFalse(solution.canPartitionKSubsets(nums, 4));;
    }
}
