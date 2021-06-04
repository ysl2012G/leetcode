package com.leetcode.algorithm.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SodukuSolver$37 {
    private char[][] board ;

    private Map<Integer, Set<Integer>> horizontalCache;
    private Map<Integer, Set<Integer>> verticalCache;
    private Map<Integer, Set<Integer>> cellCache;

    public void solveSudoku(char[][] board) {
        this.board = board;
        final int LEN = board.length;
        this.horizontalCache = new HashMap<>();
        this.verticalCache = new HashMap<>();
        this.cellCache = new HashMap<>();

        for (int i = 0; i < LEN; ++i) {
            horizontalCache.put(i, new HashSet<>());
            verticalCache.put(i, new HashSet<>());
            cellCache.put(i, new HashSet<>());
        }


        for (int i = 0; i < LEN; ++i) {
            for (int j = 0; j < LEN; ++j) {
                final char ch = board[i][j];
                if (Character.isDigit(ch)) {
                    final int digit = ch - '0';
                    horizontalCache.get(i).add(digit);
                    verticalCache.get(j).add(digit);
                    final int cellIndex = i / 3 * 3 + j / 3;
                    cellCache.get(cellIndex).add(digit);
                }
            }
        }

        backtrack(0, 0);

    }

    private boolean backtrack(int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j >= 9) {
            return backtrack(i + 1, 0);
        }

        if (board[i][j] != '.') {
            return backtrack(i, j + 1);
        }
        final int cellIndex = i / 3 * 3 + j / 3;
        for (int digit = 1; digit <= 9; ++digit) {
            if (horizontalCache.get(i).contains(digit) || verticalCache.get(j).contains(digit)
                || cellCache.get(cellIndex).contains(digit)) {
                continue;
            }
            board[i][j] = (char) (digit + '0');
            horizontalCache.get(i).add(digit);
            verticalCache.get(j).add(digit);
            cellCache.get(cellIndex).add(digit);

            if (backtrack(i, j + 1)) {
                return true;
            }

            board[i][j] = '.';
            horizontalCache.get(i).remove(digit);
            verticalCache.get(j).remove(digit);
            cellCache.get(cellIndex).remove(digit);
        }
        return false;
    }

}
