package com.leetcode.chanllenge.leetcode264;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CountNodesWithHighestScore {
    public int countHighestScoreNodes(int[] parents) {
        final int len = parents.length;
        final int[][] nodes = new int[len][2];
        for (int[] node : nodes) {
            Arrays.fill(node, -1);
        }


        int rootIndex = -1;
        for (int i = 0; i < len; ++i) {
            final int parentNode = parents[i];
            if (parentNode == -1) {
                rootIndex = i;
            } else {
                if (nodes[parentNode][0] == -1) {
                    nodes[parentNode][0] = i;
                } else {
                    nodes[parentNode][1] = i;
                }
            }
        }


        final int[][] cache = new int[len][2];
        if (nodes[rootIndex][0] != -1) {
            cache[rootIndex][0] = dfs(nodes[rootIndex][0], nodes, cache);
        }
        if (nodes[rootIndex][1] != -1) {
            cache[rootIndex][1] = dfs(nodes[rootIndex][1], nodes, cache);
        }


        long max = 0;
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            int leftSize = cache[i][0];
            int rightSize = cache[i][1];
            long extraSize = len - leftSize - rightSize - 1;

            final long currMax = Math.max(1, leftSize) * Math.max(1, rightSize) * Math.max(1, extraSize);
            if (currMax > max) {
                max = currMax;
                ans = 1;
            } else if (currMax == max) {
                ++ans;
            }
        }

        return ans;
    }

    private int dfs(int index, int[][] nodes, int[][] cache) {
        if (nodes[index][0] == -1 && nodes[index][1] == -1) {
            return 1;
        }

        if (nodes[index][0] != -1) {
            cache[index][0] = dfs(nodes[index][0], nodes, cache);
        }

        if (nodes[index][1] != -1) {
            cache[index][1] = dfs(nodes[index][1], nodes, cache);
        }

        return 1 + cache[index][0] + cache[index][1];
    }

    @Test
    public void test() {
        final int[] parents = {-1, 2, 0, 2, 0};

        final CountNodesWithHighestScore solution = new CountNodesWithHighestScore();
        solution.countHighestScoreNodes(parents);

    }
}
