package com.leetcode.chanllenge.leetcode231;

import java.util.Arrays;

public class MakeXORofAllSegmentsEqualstoZero {
    public int minChanges(int[] nums, int k) {
        final int[][] freq = new int[k][1024];

        for (int i = 0; i < nums.length; ++i) {
            ++freq[i % k][nums[i]];
        }

        int[][] memo = new int[k+1][1024];
        for(int[] sub : memo) {
            Arrays.fill(sub, (int) 1e9 + 7);
        }

        // memo[i][j] 前i个元素组成xor值为j，最小的次数
        memo[0][0] = 0;

        int preMin  = 0;
        int n = nums.length;


        for (int i = 0; i < k; ++i) {

            //第一部分：出现过的元素
            for (int j = 0; j< 1024; ++j) {
                for (int index = i; index < n; index += k) {
                    memo[i + 1][j ^ nums[index]] = Math.min(memo[i + 1][j ^ nums[index]], memo[i][j] + (int) Math.ceil((n - i) * 1.0 / k) - freq[i][nums[index]]);
                }
            }

            //第二部分： 没有出现过的元素
            int prevMin2 = (int) (1e9+ 7);
            for (int j = 0; j < 1024; ++j) {
                memo[i + 1][j] = Math.min(memo[i + 1][j], (int) Math.ceil((n - i) * 1.0 / k) + preMin);
                prevMin2 = Math.min(prevMin2, memo[i + 1][j]);
            }

            preMin = prevMin2;
        }

        return memo[k][0];


    }
}
