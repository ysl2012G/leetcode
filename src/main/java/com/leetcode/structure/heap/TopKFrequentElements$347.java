package com.leetcode.structure.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements$347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) { return new int[0]; }
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums){
            counter.merge(num, 1, Integer::sum);
        }


		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k,
				Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed());
		for (Map.Entry<Integer, Integer> entry: counter.entrySet()) {
		    queue.add(entry);
        }
		int[] res = new int[k];
		for (int i = 0; i < k ; ++i) {
		    res[i] = queue.poll().getKey();
        }
		return res;
    }
}
