package com.leetcode.chanllenge.leetcode230;

public class ClosestDessertCost {
    private int target;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        int result = helper(toppingCosts, 0, baseCosts[0]);
        for (int i = 1; i < baseCosts.length; ++i) {
            result = closest(result, helper(toppingCosts, 0, baseCosts[i]));
        }
        return result;
    }

    private int helper(int[] toppingCosts, int index, int sum) {
        if (index >= toppingCosts.length) {
            return sum;
        }

        if (sum == target) {
            return target;
        }

        int first = helper(toppingCosts, index + 1, sum);
        int second = helper(toppingCosts, index + 1, sum + toppingCosts[index]);
        int third = helper(toppingCosts, index + 1, sum + toppingCosts[index] * 2);

        sum = closest(first, closest(second, third));
        return sum;
    }

    private int closest(int first, int second) {
        final int absFirst = Math.abs(target - first);
        final int absSecond = Math.abs(target - second);
        if (absFirst == absSecond) {
            return Math.min(first, second);
        }
        return absFirst < absSecond ? first : second;
    }

    public static void main(String[] args) {

        new ClosestDessertCost().closestCost(new int[]{10}, new int[]{1}, 1);
    }

}
