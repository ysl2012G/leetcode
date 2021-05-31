package com.leetcode.chanllenge.leetcode243;

public class MinSkipsToArriveAtMeetingOnTime {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        final int LEN = dist.length;
        final int[] memo = new int[LEN];

        for (int i = 0; i < LEN; ++i) {
            for (int j = LEN - 1; j >= 0; --j) {
                memo[j] += dist[i];
                if (i < LEN - 1) {
                    memo[j] = (memo[j] + speed - 1) / speed * speed;
                }
                if (j > 0) {
                    memo[j] =Math.min(memo[j - 1] + dist[i], memo[j]);
                }
            }
        }

        for (int i = 0; i < LEN; ++i) {
            if (Long.compare(memo[i], (long) speed * hoursBefore) <= 0) {
                return i;
            }
        }
        return -1;
    }

    public int minSkipsDetail(int[] dist, int speed, int hoursBefore) {
        final int LEN = dist.length;
        final int[][] memo = new int[LEN][LEN];

        memo[0][0] = (dist[0] + speed - 1) / speed * speed;
        for (int j = 1; j < LEN; ++j) {
            memo[0][j] = dist[0];
        }


        for (int i = 1; i < LEN; ++i) {
            if (i < LEN - 1) {
                memo[i][0] = (memo[i - 1][0] + dist[i] + speed - 1) / speed * speed;
            } else {
                memo[i][0] = memo[i - 1][0] + dist[i];
            }

            for (int j = 1; j < LEN; ++j) {
                final int skip = memo[i - 1][j - 1] + dist[i];
                final int noSkip = (memo[i - 1][j] + dist[i] + speed - 1) / speed * speed;
                memo[i][j] = Math.min(skip, noSkip);
            }
        }


        for (int skip = 0; skip < LEN; ++skip) {
            if (Long.compare(memo[LEN - 1][skip], (long) speed * hoursBefore) <= 0) {
                return skip;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] dist = { 1, 3, 2};
        new MinSkipsToArriveAtMeetingOnTime().minSkips(dist, 4, 2);
    }
}
