package com.leetcode.chanllenge.biweek.leetcode54;

public class CheckIfAllTheIntegersInRangeAreCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        final int len = right - left + 1;
        final boolean[] marked = new boolean[len];


        for (int[] range : ranges) {
            final int lo = Math.max(0, range[0] - left);
            final int hi = Math.min(range[1] - left , len - 1);
            for (int i = lo; i <= hi; ++i) {
                marked[i] = true;
            }
        }

        for (boolean mark : marked) {
            if (!mark) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
		final int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
		new CheckIfAllTheIntegersInRangeAreCovered().isCovered(ranges, 2, 5);
    }
}
