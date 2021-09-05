package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;
import java.util.Comparator;

public class MaxProfitInJobScheduling$1235 {
    private static class Job {
        private final int startTime;
        private final int endTime;
        private final int profit;

        Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int getStartTime() {
            return startTime;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int len  = startTime.length;
        final Job[] jobs = new Job[len];

        for (int i = 0; i < len; ++i) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(Job::getStartTime));
        Arrays.sort(startTime);

        final int[] memo = new int[len];
        memo[len - 1] = jobs[len - 1].profit;


        for (int i = len - 2; i >= 0; --i) {
            int curr = jobs[i].profit;
            int targetTime = jobs[i].endTime;
            final int nextIndex = binarySearch(startTime, i + 1, targetTime);
            curr += nextIndex >= len ? 0 : memo[nextIndex];
            memo[i] = Math.max(curr, memo[i + 1]);
        }

        return memo[0];
    }


    private int binarySearch(int[] sortedStartTime, int index, int targetTime) {
        int lo = index;
        int hi = sortedStartTime.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            final int midStartTime = sortedStartTime[mid];
            if (midStartTime < targetTime) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
