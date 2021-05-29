package com.leetcode.chanllenge.biweek.leetcode45;

public class DeterminColorOfChessboardSquare {
    public boolean squireIsWhite(String coordinates) {
        final int row = coordinates.charAt(0) - 'a';
        final int col = coordinates.charAt(1) - '1';

        return (row + col) % 2 != 0;
    }
}
