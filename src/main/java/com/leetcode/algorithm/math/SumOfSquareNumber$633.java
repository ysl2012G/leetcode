package com.leetcode.algorithm.math;

import java.util.HashSet;
import java.util.Set;

public class SumOfSquareNumber$633 {
    public boolean judgeSquareSum(int c) {
        final Set<Integer> cache = new HashSet<>();

        long i = 0;
        while (Long.compare(i * i, c) < 0) {
            cache.add((int) (i * i));
            ++i;
        }

        for (int val : cache) {
            final int remain = c - val;
            if (cache.contains(remain)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        new SumOfSquareNumber$633().judgeSquareSum(4);
    }
}
