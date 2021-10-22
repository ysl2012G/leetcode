package com.leetcode.algorithm.dynamic.programming;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerfectSquares$279 {
    public int numSquares(int n) {
        final int[] memo = IntStream.range(0, n + 1).toArray();
        memo[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int step = 1; step * step <= i; ++step) {
                final int number = memo[i - step * step] + 1;
                memo[i] = Math.min(memo[i], number);
            }
        }
        return memo[n];
    }

    @Test
    public void test() {
        final PerfectSquares$279 solution = new PerfectSquares$279();
        Assertions.assertEquals(3, solution.numSquares(12));
    }
}
