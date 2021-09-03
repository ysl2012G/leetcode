package com.leetcode.structure.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 295:Find Median from Data Stream
 */
public class MedianFinder {
    private final PriorityQueue<Integer> left;
    private final PriorityQueue<Integer> right;
    public MedianFinder() {
        this.left = new PriorityQueue<>(Comparator.reverseOrder());
        this.right = new PriorityQueue<>(Comparator.naturalOrder());

    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }

    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return right.peek();
    }
}

