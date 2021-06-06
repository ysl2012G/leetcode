package com.leetcode.algorithm.backtracking;

public class NQueens$52 {
    private int res;
    private int n;

    public int totalNQueens(int n) {
        this.res = 0;
        this.n = n;
        final boolean[][] board = new boolean[n][n];
        backtrack(board, 0);
        return res;
    }

    private void backtrack(boolean[][] board, int row) {
        if (row == n) {
            ++res;
            return;
        }

        for (int col = 0; col < n; ++col) {
            if (isValid(board, row, col)) {
                board[row][col] = true;
                backtrack(board, row + 1);
                board[row][col] = false;
            }
        }
    }

    private boolean isValid(boolean[][] board, int i, int j) {
        if (board[i][j]) {
            return false;
        }

        // horizontal
        for (int col = 0; col < n; ++col) {
            if (board[i][col]) {
                return false;
            }
        }

        // vertical
        for (int row = 0; row < n; ++row) {
            if (board[row][j]) {
                return false;
            }
        }

        // slash
        for (int step = 1; step <= i; ++step) {
            final int row = i - step;
            final int leftCol = j - step;
            if (leftCol >= 0 && board[row][leftCol]) {
                return false;
            }

            final int rightCol = j + step;
            if (rightCol < n && board[row][rightCol]) {
                return false;
            }
        }

        for (int step = 1; step <= n - 1 - i; ++step) {
            final int row = i + step;
            final int leftCol = j - step;
            if (leftCol >= 0 && board[row][leftCol]) {
                return false;
            }

            final int rightCol = j + step;
            if (rightCol < n && board[row][rightCol]) {
                return false;
            }
        }

        return true;
    }

}
