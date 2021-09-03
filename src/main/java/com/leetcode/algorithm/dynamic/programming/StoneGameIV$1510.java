package com.leetcode.algorithm.dynamic.programming;

public class StoneGameIV$1510 {
    public boolean winnerSquareGame(int n) {
        final boolean[] memo = new boolean[n + 1];
        memo[0] = false;
        for (int i = 1;  i <= n; ++i) {
            for (int move = 1; move * move <= i; ++move) {
                if (!memo[i - move * move]) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {
        final StoneGameIV$1510 game = new StoneGameIV$1510();
        for (int i = 1; i < 16; ++i) {
            System.out.println(i + "piles result: " + game.winnerSquareGame(i));
        }
    }
}
