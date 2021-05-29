package com.leetcode.chanllenge.leetcode233;

public class MaxValueAtGivenIndexInBoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        if (n == maxSum) {
            return 1;
        }
        if (n == 1) {
            return maxSum;
        }

        final long diff = maxSum - n;

        int lo = 0;
        long hi = diff + 1;

        while (lo < hi) {
            final long mid = lo + (hi - lo) / 2;
            if (currentSum(n , index, mid) <= diff) {
                lo = (int) (mid + 1);
            } else {
                hi = mid;
            }
        }
        return lo;
    }


    private long currentSum(int n , int index, long target) {
        int left = index;
        int right = n - index - 1;

        final long leftLow = Math.max(target - left, 0);
        long currentSum =  (leftLow + target) * (target - leftLow + 1) / 2;
        final long rightLow = Math.max(target - right, 0);
        currentSum += (target - 1 + rightLow) * (target - rightLow) / 2;

        return currentSum;
    }

    public static void main(String[] args) {
        new MaxValueAtGivenIndexInBoundedArray().maxValue(6, 2,10);
    }
}
