package com.leetcode.chanllenge.leetcode214;

import java.util.Arrays;

public class SellDiminishingValueColoredBalls {
    private static final int DIVIDEND = (int) 1e9 + 7;

    public int maxProfit(int[] inventory, int orders) {
        int len = inventory.length;
        if (len == 1) {
            return getSum(inventory[0], orders, len);
        }
        Arrays.sort(inventory);
        final int[] values = new int[len + 1];
        values[len] = 0;
        for (int i = 0; i < len; ++i) {
            values[i] = inventory[len - 1 - i];
        }
        int remainOrders = orders;

        long totalValues = 0;
        for (int i = 1; i <= len; ++i) {
            final int currentValues = values[i - 1];
            int diff = currentValues - values[i];
            if (diff == 0) {
                continue;
            }
            if (remainOrders >= diff * i) {
                totalValues += getSum(currentValues, diff, i);
                remainOrders -= diff * i;
            } else {
                final int ordersPerBalls = remainOrders / i;
                final int remainder = remainOrders % i;
                totalValues += getSum(currentValues, remainOrders / i, i);
                totalValues += ((long) remainder * (currentValues - ordersPerBalls)) % DIVIDEND;
                break;
            }
        }
        return (int) (totalValues % DIVIDEND);
    }

    private int getSum(int maxValue, int orders, int multiply) {
        if (orders == 0) {
            return 0;
        }
        if (orders == 1) {
            return maxValue * multiply % DIVIDEND;
        }
        final int minValue = maxValue - orders + 1;
        final long totalSum = (long) (minValue + maxValue) * orders * multiply / 2;
        return (int) (totalSum % DIVIDEND);
    }

    public static void main(String[] args) {
        //        System.out.println((int) 1e9 + 27);
//        final int[] inventory = {497978859, 167261111, 483575207, 591815159};
        final int[] inventory = {565259708,715164401,716563713,958255469,844600740,823949511,180479359,287829385,164248818,73361150,230686692,322986846,598720034,338241127,748922260,181241085,833659853,509571179,250093451,690995620,703292727,595636202};
        final int orders = 650114768;
        System.out.println(new SellDiminishingValueColoredBalls().maxProfit(inventory, orders));
    }
}
