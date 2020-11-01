package com.leetcode.algorithm.dynamic.programming;

/**
 * leetcode : 309
 */
public class BuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int prevBuy = 0;
        int sell = 0;
        int prevSell = 0;
        for (int price : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + price, prevSell);
        }
        return sell;
    }
}
