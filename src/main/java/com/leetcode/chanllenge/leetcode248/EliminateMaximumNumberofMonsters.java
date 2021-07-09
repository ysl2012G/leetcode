package com.leetcode.chanllenge.leetcode248;

import java.util.Arrays;

/**
 * sort
 */
public class EliminateMaximumNumberofMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        final double[] costTimes = new double[dist.length];
        for (int i = 0; i < costTimes.length; ++i) {
            costTimes[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(costTimes);
        int num = 0;
        for (double costTime : costTimes) {
            if (Double.compare(num, costTime) >= 0) {
                break;
            }
            ++num;
        }
        return num;
    }
}
