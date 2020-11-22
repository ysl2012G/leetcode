package com.leetcode.chanllenge.leetcode216;

import java.util.Arrays;

public class MinInitialEnergyFinishTasks {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a1, a2) -> (a1[1] - a1[0]) - (a2[1] - a2[0]));
        int res = 0;
        for (int[] task : tasks) {
            res = Math.max(res + task[0], task[1]);
        }
        return res;
    }
}
