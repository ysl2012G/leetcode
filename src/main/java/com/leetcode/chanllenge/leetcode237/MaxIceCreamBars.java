package com.leetcode.chanllenge.leetcode237;

import java.util.Arrays;

public class MaxIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        final int LEN = costs.length;
        Arrays.sort(costs);

        int index = 0;
        int res = 0;

        while (index < LEN) {
            coins -= costs[index++];
            if (coins < 0) {
                break;
            }
            ++res;
        }

        return res;

    }

    public static void main(String[] args) {
//        final int[] costs = {7,3,3,6,6,6,10,5,9,2};
//        final int[] costs = {1, 6, 3, 1, 2, 5};
        final int[] costs = {1, 3, 2, 4, 1};

        System.out.println(new MaxIceCreamBars().maxIceCream(costs, 7));
    }

}
