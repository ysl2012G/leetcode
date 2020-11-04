package com.leetcode.chanllenge.leetcode213;

import java.util.Arrays;

/**
 * create by shuanglin on 2020/11/1
 */
public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        if (n == 1) {
            return 5;
        }

        int[] previous = {1, 1, 1, 1, 1};
        for (int i = 1; i < n; ++i) {
            int sum = Arrays.stream(previous).sum();

            final int[] current = new int[5];
            current[0] = sum;
            sum -= previous[0];
            current[1] = sum;
            sum -= previous[1];
            current[2] = sum;
            sum -= previous[2];
            current[3] = sum;
            sum -= previous[3];
            current[4] = sum;

            previous = current;
        }

        return Arrays.stream(previous).sum();
    }

    public static void main(String[] args) {
        System.out.println(new CountSortedVowelStrings().countVowelStrings(33));
    }

}
