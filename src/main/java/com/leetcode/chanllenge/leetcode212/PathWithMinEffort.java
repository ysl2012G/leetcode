package com.leetcode.chanllenge.leetcode212;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinEffort {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Node {
        private final int x;
        private final int y;
        private int effort;

        private Node(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }

        public int getEffort() {
            return effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        final int[][] efforts = new int[row][col];
        for (int[] rowEffort : efforts) {
            Arrays.fill(rowEffort, Integer.MAX_VALUE);
        }

        final boolean[][] isVisited = new boolean[row][col];

        final PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getEffort));
        priorityQueue.add(new Node(0, 0, 0));

        while (!priorityQueue.isEmpty()) {
            final Node current = priorityQueue.poll();
            isVisited[current.x][current.y] = true;
            if (current.x == row -1 && current.y == col - 1) {
                return current.effort;
            }
            for (int[] direction: directions) {
                final int nextX = current.x + direction[0];
                final int nextY = current.y + direction[1];
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || isVisited[nextX][nextY]) {
                    continue;
                }

                final int currentEffort = Math.max(Math.abs(heights[nextX][nextY] - heights[current.x][current.y]), current.effort);
                if (currentEffort < efforts[nextX][nextY]) {
                    efforts[nextX][nextY] = currentEffort;
                    priorityQueue.offer(new Node(nextX, nextY, currentEffort));
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
//        final int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        final int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(new PathWithMinEffort().minimumEffortPath(heights));
    }
}
