package com.leetcode.chanllenge.leetcode267;

public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        final int len = tickets.length;
        final int target = tickets[k];

        int ans = 0;
        for (int i = 0; i <= k; ++i) {
            ans += Math.min(tickets[i], target);
        }
        for (int i = k + 1; i < len; ++i) {
            ans += Math.min(tickets[i], target - 1);
        }

        return ans;
    }
}
