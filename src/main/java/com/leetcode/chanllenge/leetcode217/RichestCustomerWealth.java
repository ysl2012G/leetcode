package com.leetcode.chanllenge.leetcode217;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        for (int[] customer: accounts) {
            int currentWealth = 0;
            for (int bankWealth : customer) {
                currentWealth += bankWealth;
            }
            richest = Math.max(richest, currentWealth);
        }
        return richest;
    }
}
