package com.leetcode.algorithm.dynamic.programming;

import java.util.Arrays;

public class LastStoneWeight$1049 {
    public int lastStoneWeightII(int[] stones) {
		if (stones == null || stones.length == 0) {
			return 0;
		}
		int len = stones.length;
		int sum = 0;
		for (int stone : stones) {
			sum += stone;
		}

		int avgSum = sum >> 1;
		boolean[] dp = new boolean[avgSum + 1];
		Arrays.fill(dp, false);
		dp[0] = true;

		for (int i = 1; i <= len; i++) {
			for (int j = avgSum; j >= stones[i - 1]; j--) {
				dp[j] = dp[j] || dp[j - stones[i - 1]];
			}
		}

		int pos = sum / 2;
		while (pos >= 0) {
			if (dp[pos]) {
				break;
			}
			pos--;
		}

		return sum - pos * 2;
    }
}
