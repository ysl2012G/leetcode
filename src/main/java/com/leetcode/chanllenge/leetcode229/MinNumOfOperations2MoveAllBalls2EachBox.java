package com.leetcode.chanllenge.leetcode229;

public class MinNumOfOperations2MoveAllBalls2EachBox {
    public int[] minOperations(String boxes) {
        final int[] ops = new int[boxes.length()];

        int left = '1' == boxes.charAt(0) ? 1 : 0;
        int right = 0;

        int current = 0;
        for (int i = 1; i < boxes.length(); ++i) {
            if ('1' == boxes.charAt(i)) {
                ++right;
                current += i;
            }
        }


        ops[0] = current;

        for (int i = 1; i < boxes.length(); ++i) {
            ops[i] = ops[i - 1] + left - right;

            if ('1' == boxes.charAt(i)) {
                ++left;
                --right;
            }
        }

        return ops;
    }

    public static void main(String[] args) {
        new MinNumOfOperations2MoveAllBalls2EachBox().minOperations("110");
    }
}
