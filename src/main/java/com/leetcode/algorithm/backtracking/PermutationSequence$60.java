package com.leetcode.algorithm.backtracking;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationSequence$60 {
    public String getPermutation(int n, int k) {


        final int[] memo = new int[n + 1];
        memo[0] = 1;
        for (int i = 1; i <= n; ++i) {
            memo[i] = memo[i - 1] * i;
        }
        final List<Integer> numbers = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());

        k = k - 1;
        final StringBuilder builder = new StringBuilder();
        for (int i = n; i >= 1; --i) {
            final int index = k / memo[i - 1];
            k = k % memo[i - 1];
            builder.append(numbers.remove(index));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        new PermutationSequence$60().getPermutation(3, 3);
    }
}
