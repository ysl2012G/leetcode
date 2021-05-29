package com.leetcode.chanllenge.leetcode226;

import java.util.Arrays;

public class MaxBallsInBox {

    public int countBalls(int lowLimit, int highLimit) {
        final int MAX_BOX = 100;
        final int[] box = new int[MAX_BOX];


        int init = lowLimit;
        int previous = 0;
        while (init != 0) {
            previous += init % 10;
            init /= 10;
        }

        ++box[previous - 1];

        for (int i = lowLimit; i < highLimit; ++i) {
            int current = i;
            while (current % 10 == 9) {
                previous -= 9;
                current /= 10;
            }
            ++previous;
            ++box[previous - 1];
        }

        Arrays.sort(box);

        return box[MAX_BOX - 1];
    }

    public static void main(String[] args) {
        new MaxBallsInBox().countBalls(8 ,16);
    }
}

