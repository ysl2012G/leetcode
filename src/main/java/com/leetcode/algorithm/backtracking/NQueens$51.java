package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens$51 {
    private List<List<String>> res;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        this.n = n;
        final boolean[][] board = new boolean[n][n];
        backtrack(board, 0);
        return res;
    }

    private void backtrack(boolean[][] board, int row) {
        if (row == n) {
            res.add(convertString(board));
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

    private List<String> convertString(boolean[][] board) {
        final List<String> boardString = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            final StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                builder.append(board[i][j] ? 'Q' : '.');
            }
            boardString.add(builder.toString());
        }
        return boardString;
    }

    public static void main(String[] args) {
        new NQueens$51().solveNQueens(4);
    }
}
