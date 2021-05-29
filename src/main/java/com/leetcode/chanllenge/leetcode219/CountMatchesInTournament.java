package com.leetcode.chanllenge.leetcode219;

public class CountMatchesInTournament {
    public int numberOfMatches(int n) {
        int matches = 0;
        int remain = n;
        while (remain > 1) {
            final int bye = remain % 2;
            remain >>= 1;
            matches += remain;
            remain += bye;
        }
        return matches;
    }

    public static void main(String[] args) {
        System.out.println(new CountMatchesInTournament().numberOfMatches(14));
    }
}
