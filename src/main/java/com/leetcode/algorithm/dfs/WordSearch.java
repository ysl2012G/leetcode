package com.leetcode.algorithm.dfs;

public class WordSearch {
    private static final int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] isVisited;
    private int rowLen;
    private int colLen;
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word) {
        rowLen = board.length;
        colLen = board[0].length;
        this.board = board;
        this.word = word;

        isVisited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        isVisited[i][j] = true;
        boolean existed = false;
        for (int[] move: direction) {
            int currRow = i + move[0];
            int currCol = j + move[1];
            if (isValidCell(currRow, currCol) && !isVisited[currRow][currCol] && dfs(currRow, currCol, index + 1)) {
                existed = true;
                break;
            }
        }
        isVisited[i][j] = false;
        return existed;
    }

    private boolean isValidCell(int i , int j ) {
        return (i >= 0 && i < rowLen && j >= 0 && j < colLen);
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        new WordSearch().exist(board, word);
    }
}
