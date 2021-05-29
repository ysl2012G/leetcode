package com.leetcode.chanllenge.leetcode233;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfOrdersInBacklog {
    private static class Order {
        final int price;
        int amount;

        Order(int price, int amount) {
            this.price = price;
            this.amount = amount;
        }

        public int getPrice() {
            return price;
        }
    }


    public int getNumberOfBacklogOrders(int[][] orders) {
        final int MODULO = (int)1e9 + 7;

        final PriorityQueue<Order> buyOrders = new PriorityQueue<>(Comparator.comparingInt(Order::getPrice).reversed());
        final PriorityQueue<Order> sellOrders = new PriorityQueue<>(Comparator.comparingInt(Order::getPrice));


        long totalSum = 0;
        long execOrders = 0;

        for (int[] order : orders) {
            final int price = order[0];
            int amount = order[1];
            final int orderType = order[2];

            totalSum += amount;

            // buy
            if (orderType == 0) {
                while (!sellOrders.isEmpty()) {
                    final Order sellOrder = sellOrders.peek();
                    if (sellOrder.getPrice() > price) {
                        break;
                    }
                    int diff = sellOrder.amount - amount;

                    if (diff > 0) {
                        sellOrder.amount = diff;
                        execOrders += amount * 2;
                        amount = 0;
                        break;
                    } else {
                        sellOrders.poll();
                        execOrders += sellOrder.amount * 2;
                        amount = Math.abs(diff);
                    }
                }
                if (amount > 0) {
                    buyOrders.add(new Order(price, amount));
                }
            } else {
                // sell
                while (!buyOrders.isEmpty()) {
                    final Order buyOrder = buyOrders.peek();
                    if (buyOrder.getPrice() < price) {
                        break;
                    }
                    int diff = buyOrder.amount - amount;
                    if (diff > 0) {
                        buyOrder.amount = diff;
                        execOrders += amount * 2;
                        amount = 0;
                        break;
                    } else {
                        buyOrders.poll();
                        execOrders += buyOrder.amount * 2;
                        amount = Math.abs(diff);
                    }
                }
                if (amount > 0) {
                    sellOrders.add(new Order(price, amount));
                }
            }
        }
        return (int) ((totalSum - execOrders) % MODULO);
     }

    public static void main(String[] args) {
        final int[][] orders = {{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        new NumberOfOrdersInBacklog().getNumberOfBacklogOrders(orders);
    }
}
