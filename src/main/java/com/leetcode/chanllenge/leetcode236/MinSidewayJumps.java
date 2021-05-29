package com.leetcode.chanllenge.leetcode236;

public class MinSidewayJumps {
    public int minSideJumps(int[] obstacles) {
        final int len = obstacles.length;
        int firstLane = 1;
        int secondLane = 0;
        int thirdLane = 1;

        for (int i = 1; i < len; ++i) {
            final int obstacle = obstacles[i];
            if (obstacle == 1) {
                ++firstLane;
                secondLane = getLatestJump(secondLane, firstLane, thirdLane);
                thirdLane = getLatestJump(thirdLane, firstLane, secondLane);
                firstLane = -1;
            } else if (obstacle == 2) {
                ++secondLane;
                firstLane = getLatestJump(firstLane, secondLane, thirdLane);
                thirdLane = getLatestJump(thirdLane, firstLane, secondLane);
                secondLane = -1;
            } else if (obstacle == 3) {
                ++thirdLane;
                firstLane = getLatestJump(firstLane, secondLane, thirdLane);
                secondLane = getLatestJump(secondLane, firstLane, thirdLane);
                thirdLane = -1;
            } else {
                firstLane = getLatestJump(firstLane, secondLane, thirdLane);
                secondLane = getLatestJump(secondLane, firstLane, thirdLane);
                thirdLane = getLatestJump(thirdLane, firstLane, secondLane);
            }
        }
        return Math.min(firstLane, Math.min(secondLane, thirdLane));
    }

    private int getLatestJump(int currentLane, int lane1, int lane2) {
        if (currentLane == -1) {
            return Math.min(lane1, lane2) + 1;
        }
        return currentLane;
    }

    public static void main(String[] args) {
        final int[] obstacles = {0 , 1, 2, 3, 0};
        System.out.println(new MinSidewayJumps().minSideJumps(obstacles));
    }

}
