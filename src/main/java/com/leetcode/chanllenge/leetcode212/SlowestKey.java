package com.leetcode.chanllenge.leetcode212;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int len = releaseTimes.length;
        final int[] costTimes = new int[len];
        int previousReleaseTime = 0;
        for (int i = 0; i < len; ++i) {
            int currentReleaseTime = releaseTimes[i];
            costTimes[i] = currentReleaseTime - previousReleaseTime;
            previousReleaseTime = currentReleaseTime;
        }

        char slowKey = keysPressed.charAt(0);
        int slowTime = costTimes[0];
        for (int i = 1; i < len; ++i) {
            final int costTime = costTimes[i];
            final char currKey = keysPressed.charAt(i);
            if (slowTime == costTime) {
                slowKey = currKey > slowKey ? currKey : slowKey;
                slowTime = costTime;
            } else if (slowTime < costTime) {
                slowKey = currKey;
                slowTime = costTime;
            }
        }

        return slowKey;
    }
}
