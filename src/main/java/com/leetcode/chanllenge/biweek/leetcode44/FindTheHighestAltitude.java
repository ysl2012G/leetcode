package com.leetcode.chanllenge.biweek.leetcode44;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
         int highest = 0;
         int current = 0;
         for (int increment: gain) {
             current += increment;
             highest = Math.max(current, highest);
         }
         return highest;
    }
}
