package com.leetcode.chanllenge.leetcode237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    private static class Task {
        final int index;
        final int enqueueTime;
        final int processingTime;

        public Task(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }

        public int getIndex() {
            return index;
        }

        public int getEnqueueTime() {
            return enqueueTime;
        }

        public int getProcessingTime() {
            return processingTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        final int LEN = tasks.length;


        final List<Task> sorted = new ArrayList<>();
        for (int i = 0; i < LEN; ++i) {
            sorted.add(new Task(i, tasks[i][0], tasks[i][1]));
        }

        sorted.sort(Comparator.comparingInt(Task::getEnqueueTime).thenComparingInt(Task::getProcessingTime));

        final List<Task> res = new LinkedList<>();
        int processed = 0;
        final Task first = sorted.get(processed);
        int currTime = first.enqueueTime + first.processingTime;
        res.add(first);

        final PriorityQueue<Task> processingQueue = new PriorityQueue<>(Comparator.comparingInt(Task::getProcessingTime).thenComparingInt(Task::getIndex));
        while (processed < LEN - 1) {
            final int rightBound = binarySearch(sorted, processed, currTime);
            processingQueue.addAll(sorted.subList(processed + 1, rightBound));
            processed = rightBound - 1;

            //1.  当前没有
            if (processingQueue.isEmpty()) {
                ++processed;
                final Task task = sorted.get(processed);
                currTime = task.enqueueTime + task.processingTime;
                res.add(task);
                continue;
            }

            final Task task = processingQueue.poll();
            currTime += task.processingTime;
            res.add(task);

        }

        while (!processingQueue.isEmpty()) {
            res.add(processingQueue.poll());
        }

        return res.stream().mapToInt(Task::getIndex).toArray();
    }

    private int binarySearch(List<Task> sorted, int processed, int currTime) {
        int lo = processed + 1;
        int hi = sorted.size();
        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;
            if (sorted.get(mid).enqueueTime <= currTime) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
		final int[][] tasks = {{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34},
				{33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};

        final int[] res = new SingleThreadedCPU().getOrder(tasks);
        Arrays.stream(res).forEach(System.out::println);
    }
}
