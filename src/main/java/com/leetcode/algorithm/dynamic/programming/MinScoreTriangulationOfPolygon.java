package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;

public class MinScoreTriangulationOfPolygon {
    public int leastInterval(char[] tasks, int n) {
        int[] cache = new int[26];
        for (char task : tasks) {
            ++cache[task - 'A'];
        }
        Arrays.sort(cache);
        int index = 25;
        int max = cache[index];
        while (index >= 0 && cache[index] == max) {
            --index;
        }

        return Math.max(tasks.length, (n + 1) * (max - 1) + 25 - index);
    }
}