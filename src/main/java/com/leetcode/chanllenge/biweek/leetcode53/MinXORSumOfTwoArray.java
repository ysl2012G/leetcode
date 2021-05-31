package com.leetcode.chanllenge.biweek.leetcode53;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinXORSumOfTwoArray {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        final Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        final int LEN = nums1.length;

        final int[][] memo = new int[LEN][(1 << LEN)];
        for (int[] part : memo) {
            Arrays.fill(part, Integer.MAX_VALUE);
        }


        for (int i = 0; i < LEN; ++i) {
            for (int j = 0; j < LEN; ++j) {
                final Map<Integer, Integer> map = cache.computeIfAbsent(i, HashMap::new);
                final int temp = nums1[i] ^ nums2[j];
                map.put(1 << j, temp);

                //memo initialization
                if (i == 0) {
                    memo[0][1 << j] = temp;
                }
            }
        }

        for (int i = 0; i < LEN - 1; ++i) {
            for (int j = 0; j < memo[0].length; ++j) {
                if (memo[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                final Map<Integer, Integer> map = cache.get(i + 1);
                for (int bitCode : map.keySet()) {
                    if ((bitCode & j) == 0) {
                        // core
						memo[i + 1][bitCode | j] = Math.min(memo[i + 1][bitCode | j], memo[i][j] + map.get(bitCode));
					}
				}
			}
		}

		return memo[LEN - 1][(1 << LEN) - 1];
    }
}
