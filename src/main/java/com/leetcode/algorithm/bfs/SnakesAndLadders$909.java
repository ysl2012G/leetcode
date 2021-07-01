package com.leetcode.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders$909 {
    private int[][] board;
    private int len;

    public int snakesAndLadders(int[][] board) {
        this.board = board;
        this.len = board.length;
        final int target = len * len;

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        final boolean[] visited = new boolean[target + 1];
        visited[1] = true;
        int move = 0;
        while (!queue.isEmpty()) {
            for (int cnt = queue.size(); cnt > 0; -- cnt) {
                final int index = queue.poll();
                if (index == target) {return move;}
                for (int step = 1; step <= 6 && index + step <= target; ++ step) {
                    int dest = getDestPos(index + step);
                    if (dest == - 1) { dest = index + step; }
                    if (visited[dest]) { continue; }
                    visited[dest] = true;
                    queue.add(dest);
                }
            }
            ++move;
        }
        return -1;
    }

    private int getDestPos(int index) {
        final int rowFromBottom = (index - 1) / len;
        final int rowIndex = len - 1 - rowFromBottom;
        final int colFromZigZag = (index - 1) % len;
        final int colIndex = (rowFromBottom % 2 == 0) ? colFromZigZag : len - 1 - colFromZigZag;

        return board[rowIndex][colIndex];
    }

    public static void main(String[] args) {
		final int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
				{-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};

		new SnakesAndLadders$909().snakesAndLadders(board);
    }
}
