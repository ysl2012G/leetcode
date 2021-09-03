package com.leetcode.algorithm.dynamic.programming;

public class StoneGameV$1563 {

    public int stoneGameV(int[] stoneValue) {
        final int len = stoneValue.length;
		final int[] preSums = new int[len + 1];
		for (int i = 0; i < len; ++i) {
			preSums[i + 1] = preSums[i] + stoneValue[i];
		}
		final int[][] memo = new int[len][len];
		final int[][] left = new int[len][len];
		final int[][] right = new int[len][len];

		for (int i = 0; i < len; ++i) {
		    left[i][i] = stoneValue[i];
		    right[i][i] = stoneValue[i];
        }

		for (int step = 1; step < len; ++step) {
		    for (int i = 0; i < len - step; ++i) {
		        int j = i + step;
		        int k = binarySearch(preSums, i, j);
		        final int totalSum = preSums[j + 1] - preSums[i];
		        final int midSum = preSums[k + 1] - preSums[i];
		        if (midSum * 2 == totalSum) {
		            memo[i][j] = Math.max(left[i][k], right[k + 1][j]);
                } else {
					memo[i][j] = Math.max(k == i ? 0 : left[i][k - 1], k == j ? 0 : right[k + 1][j]);
                }
		        left[i][j] = Math.max(left[i][j - 1], totalSum + memo[i][j]);
		        right[i][j] = Math.max(right[i + 1][j], totalSum + memo[i][j]);
            }
        }

		return memo[0][len - 1];
    }

    private int binarySearch(int[] preSums, int left, int right) {
        final int total = preSums[right + 1] - preSums[left];
        int lo = left;
        int hi = right + 1;
        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;
            final int midSum = preSums[mid + 1] - preSums[left];
            if (midSum * 2 < total) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    


//    public int stoneGameV(int[] stoneValue) {
//        final int len = stoneValue.length;
//        final int[] preSums = new int[len + 1];
//        for (int i = 0; i < len; ++i) {
//            preSums[i + 1] = preSums[i] + stoneValue[i];
//        }
//        final int[][] memo = new int[len][len];
//        return helper(memo, preSums, 0, len - 1);
//    }
//
//    private int helper(int[][] memo, int[] preSums, int left, int right) {
//        if (left == right) {
//            return 0;
//        }
//        if (memo[left][right] > 0) {
//            return memo[left][right];
//        }
//
//
//        for (int i = left; i < right; ++i) {
//            final int leftSum = preSums[i + 1] - preSums[left];
//            final int rightSum = preSums[right + 1] - preSums[i + 1];
//            if (leftSum < rightSum) {
//                memo[left][right] = Math.max(memo[left][right], leftSum + helper(memo, preSums, left, i));
//            } else if (leftSum > rightSum) {
//                memo[left][right] = Math.max(memo[left][right], rightSum + helper(memo, preSums, i + 1, right));
//            } else {
//                memo[left][right] = Math.max(memo[left][right], Math.max(leftSum + helper(memo, preSums, left, i), rightSum + helper(memo, preSums, i + 1, right)));
//            }
//        }
//
//        return memo[left][right];
//    }

    public static void main(String[] args) {
		final int[] stoneValues = {98,77,24,49,6,12,2,44,51,96};
		System.out.println(new StoneGameV$1563().stoneGameV(stoneValues));
    }
}
