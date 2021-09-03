package com.leetcode.chanllenge.biweek.leetcode54;

public class FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int k) {
        final int LEN = chalk.length;
        final long[] preSum = new long[LEN];
        preSum[0] = chalk[0];
        for (int i = 1; i < LEN; ++i) {
            preSum[i] = preSum[i - 1] + chalk[i];
        }

        final long totalSum = preSum[LEN - 1];
        final long remain  = k % totalSum;

        if (remain == 0) {
            return 0;
        }

        // binarySearch
        int lo = 0;
        int hi = LEN;
        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;
            if (preSum[mid] <= remain) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        final int[] chalk = {5, 1, 5};
        new FindTheStudentThatWillReplaceTheChalk().chalkReplacer(chalk, 22);
    }
}
