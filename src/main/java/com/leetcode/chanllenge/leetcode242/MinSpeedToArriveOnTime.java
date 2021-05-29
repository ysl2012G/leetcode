package com.leetcode.chanllenge.leetcode242;

import java.util.Arrays;

public class MinSpeedToArriveOnTime {
    public  int minSpeedOnTime(int[] dist, double hour) {
        if (Double.compare(dist.length - 1, hour) > 0) {
            return -1;
        }
        final int maxSpeed = Arrays.stream(dist).max().orElse(0) * 100;

        int lo = 1;
        int hi  = maxSpeed + 1;
        while (lo < hi) {
            final int midSpeed = lo + (hi - lo) / 2;

            final double cost = getTime(dist, midSpeed);
            if (Double.compare(cost, hour) <= 0) {
                hi = midSpeed;
            }  else {
                lo = midSpeed + 1;
            }
        }
        return lo;
    }

    private double getTime(int[] dist, double speed) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; ++i) {
			time += Math.ceil(dist[i] / speed);
        }
        time += dist[dist.length - 1] / speed;
        return time;
    }

    public static void main(String[] args) {
        final int[] dist = { 1, 1, 100000};
        final double hour = 2.01;
        System.out.println(new MinSpeedToArriveOnTime().minSpeedOnTime(dist, hour));
//
//        System.out.println(Math.ceil(1 / 2.0));

    }


}
