package com.leetcode.algorithm.math;

public class Transform2Chessboard$782 {
    public int movesToChessboard(int[][] board) {
        final int len = board.length;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if ((board[0][0] ^ board[i][j] ^ board[i][0] ^ board[0][j]) == 1) {
                    return -1;
                }
            }
        }

        int rowSum = 0;
        int colSum = 0;
        int rowSwap = 0;
        int colSwap = 0;
        for (int i = 0; i< len; ++i) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] != i % 2) {
                ++rowSwap;
            }
            if (board[0][i] != i % 2)  {
                ++colSwap;
            }
        }

        if (rowSum < len / 2 || rowSum > (len + 1) / 2) {
            return -1;
        }
        if (colSum < len / 2 || colSum > (len + 1) / 2) {
            return -1;
        }

        if (len % 2 == 1) {
            if (colSwap % 2 == 1) {
                colSwap = len - colSwap;
            }
            if (rowSwap % 2 == 1) {
                rowSwap = len - rowSwap;
            }
        } else {
            rowSwap = Math.min(rowSwap, len - rowSwap);
            colSwap = Math.min(colSwap, len - colSwap);
        }

        return (rowSwap + colSwap) / 2;
    }
}
