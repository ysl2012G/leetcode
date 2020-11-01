package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Leetcode: 1000
 */
public class MinCostToMergeStones {
    public int mergeStones(int[] stones, int k) {
        int len = stones.length;
        if ((len - 1) % (k - 1)  != 0) {
            return -1;
        }
        int[] sums = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            sums[i + 1] = stones[i] + sums[i];
        }

        int[][] memo = new int[len][len];
        for (int i = len - k; i >= 0; --i) {
            for (int j = i + k - 1; j < len; ++j) {
                for (int t = i; t < j; t += k - 1 ) {
                    int cost = memo[i][t] + memo[t + 1][j];
                    memo[i][j] = Math.min(memo[i][j] == 0 ? Integer.MAX_VALUE : memo[i][j], cost);
                }
                if ((j - i) % (k - 1) == 0) {
                    memo[i][j] += sums[j + 1] - sums[i];
                }
            }
        }
//        for (int interval = k; interval <= len; ++ interval) {
//            for (int i = 0; i + interval <= len; ++i) {
//                int j = i + interval - 1;
//                memo[i][j] = Integer.MAX_VALUE;
//                for (int t = i; t < j; t += k - 1) {
//                    memo[i][j] = Math.min(memo[i][j], memo[i][t] + memo[t + 1][j]);
//                }
//                if ((j - i) % (k - 1) == 0) {
//                    memo[i][j] += sums[j + 1] - sums[i];
//                }
//            }
//        }

        for (int[] parts : memo) {
            System.out.println(Arrays.stream(parts).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        }

        return memo[0][len - 1];
    }

    public static void main(String[] args) {
        final int[] stones = {3, 5, 1, 2, 6};
        System.out.println(new MinCostToMergeStones().mergeStones(stones, 3));
    }
}
