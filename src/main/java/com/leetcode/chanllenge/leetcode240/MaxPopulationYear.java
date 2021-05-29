package com.leetcode.chanllenge.leetcode240;

public class MaxPopulationYear {
    public int maximumPopulation(int[][] logs) {
        final int FIRST_YEAR = 1950;
        final int[] populations = new int[100];

        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; ++i) {
                ++populations[i - FIRST_YEAR];
            }
        }

        int maxPopulation = 0;
        int maxYear = 0;
        for (int i = 0; i < 100; ++i) {
            if (maxPopulation < populations[i]) {
                maxPopulation = populations[i];
                maxYear = i + FIRST_YEAR;
            }
        }
        return maxYear;
    }

    public static void main(String[] args) {
        final int[][] logs = {{1993, 1999}, {2000, 2010}};
        new MaxPopulationYear().maximumPopulation(logs);
    }
}
