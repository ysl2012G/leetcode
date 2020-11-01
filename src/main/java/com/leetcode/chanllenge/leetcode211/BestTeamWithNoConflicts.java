package com.leetcode.chanllenge.leetcode211;

import java.util.Arrays;
import java.util.Comparator;

public class BestTeamWithNoConflicts {
    private static class Player {
        private int score;
        private int age;

        Player(int score, int age) {
            this.score = score;
            this.age = age;
        }

        public int getScore() {
            return score;
        }

        public int getAge() {
            return age;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        final Player[] players = new Player[len];
        for (int i = 0; i < len; ++i) {
            players[i] = new Player(scores[i], ages[i]);
        }

        Arrays.sort(players, Comparator.comparingInt(Player::getAge).thenComparingInt(Player::getScore).reversed());

        int res = 0;
        int[] memo = new int[len];
        for (int i = 0; i < len; ++i) {
            final int score = players[i].score;
            memo[i] = score;
            for (int j = 0; j < i; ++j) {
                if (players[j].score >= score) {
                    memo[i] = Math.max(memo[i], memo[j] + score);
                }
            }
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        final int[] scores = {1,3,5,10,15};
        final int[] ages = {1,2,3,4,5};
        new BestTeamWithNoConflicts().bestTeamScore(scores, ages);

    }
}
