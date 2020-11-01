package com.leetcode.chanllenge.leetcode200;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinSwapsToArrangeBinaryGrid {
	public int minSwags(int[][] grid) {
		int len = grid.length;
		List<Queue<Integer>> tailZeros = new ArrayList<>();
		for (int i = 0; i <= len; ++i) {
            tailZeros.add(new PriorityQueue<>());
        }
		for (int i = 0; i < len; i++) {
			final int index = i;
			int[] row = grid[i];
			int zeros = tailZeros(row);
            tailZeros.get(zeros).add(i);
		}

		int[] needsorted = new int[len];
        for (int i = len - 1; i >= 0; --i) {
            Queue<Integer> queue = tailZeros.get(i);
            queue.addAll(tailZeros.get(i + 1));
            if (queue.isEmpty()) {
                return -1;
            }
            needsorted[i] = queue.poll();
        }

        int swaps = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
				if (needsorted[i] < needsorted[j]) {
                    ++swaps;
				}
            }
        }
        return swaps;
	}

	private int tailZeros(int[] row) {
		int count = 0;
		for (int i = row.length - 1; i >= 0; --i) {
			if (row[i] == 0) {
				++count;
			} else {
				break;
			}
		}
		return count;
	}


}
