package com.leetcode.structure.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKSmallestSumWIthSortedMatrix$1439 {
    public int kthSmallest(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        if (row == 1) {
            Arrays.sort(mat[0]);
            return col > k ? mat[0][k - 1] : mat[0][col - 1];
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i ++) {
            queue.offer(mat[i]);
        }
        while (queue.size() != 1) {
            int size = queue.size();
            for (int i = 0; i < (size >> 1); i ++) {
                int[] nums1 = queue.poll();
                int[] nums2 = queue.poll();
                int[] res = kthSmallestPair(nums1, nums2, k);
                queue.offer(res);
            }
        }
        int[] res = queue.poll();
        return res[0];
    }

    private int[] kthSmallestPair(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                priorityQueue.offer(nums1[i] + nums2[j]);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        int size = priorityQueue.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++){
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,3,11}, {2,4,6}};
        int k = 5;
        System.out.println(new FindKSmallestSumWIthSortedMatrix$1439().kthSmallest(mat, 5));
    }


}
