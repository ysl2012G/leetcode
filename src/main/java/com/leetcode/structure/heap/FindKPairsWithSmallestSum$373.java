package com.leetcode.structure.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum$373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int o1Sum = o1.get(0) + o1.get(1);
            int o2Sum = o2.get(0) + o2.get(1);
            return o2Sum - o1Sum;
        });

        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++) {
                priorityQueue.offer(Arrays.asList(nums1[i], nums2[j]));
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        return new ArrayList<>(priorityQueue);
    }
}
