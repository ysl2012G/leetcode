package com.leetcode.algorithm.dynamic.programming;

public class BestBuyAndSellStock$188 {
	public int maxProfit(int k, int[] prices) {
		if (prices == null) {
			return 0;
		}
		int len = prices.length;
		if (len == 0) {
			return 0;
		}


		if (k >= (len >> 1)) {
			return greedy(prices);
		}

		int[] global = new int[k + 1];
		int[] local = new int[k + 1];
		for (int i = 0; i < len - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			// potential reason: the more nums of transaction, the more profit may get.
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[k];
	}

	private int greedy(int[] prices) {
		int res = 0;
		int len = prices.length;
		for (int i = 0; i < len - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			if (diff > 0) {
				res += diff;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] prices = {3, 2, 6, 5, 0, 3};
		System.out.println(new BestBuyAndSellStock$188().maxProfit(2, prices));
	}
}
