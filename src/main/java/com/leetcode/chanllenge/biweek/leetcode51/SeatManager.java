package com.leetcode.chanllenge.biweek.leetcode51;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SeatManager {
    private final PriorityQueue<Integer> queue;
    private final Set<Integer> reserved;
    public SeatManager(int n) {
        this.queue = new PriorityQueue<>(n);
        for (int i = 1; i <= n; ++i) {
            queue.add(i);
        }
        this.reserved = new HashSet<>();
    }

    public int reserve() {
        if (queue.isEmpty()) {
            return -1;
        }
        final int seatNumber = queue.poll();
        reserved.add(seatNumber);
        return seatNumber;
    }

    public void unreserve(int seatNumber) {
        if (reserved.remove(seatNumber)) {
            queue.add(seatNumber);
        }
    }
}
