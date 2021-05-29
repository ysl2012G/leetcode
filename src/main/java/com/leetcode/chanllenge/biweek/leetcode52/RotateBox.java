package com.leetcode.chanllenge.biweek.leetcode52;

public class RotateBox {
    public char[][] rotateTheBox(char[][] box) {
        final int row = box.length;
        final int col = box[0].length;
        final char[][] rotated = new char[col][row];

        for (int i = 0; i < row; ++i) {
            int previousStone = 0;
            int unprocessed = 0;
            for (int j = 0; j < col; ++j) {
                switch (box[i][j]) {
                case '#':
                    ++previousStone;
                    break;
                case '*':
                    rotated[j][row - i - 1] = '*';
                    for (; unprocessed < j - previousStone; ++unprocessed) {
                        rotated[unprocessed][row - i - 1] = '.';
                    }
                    for (; unprocessed < j; ++unprocessed) {
                        rotated[unprocessed][row - i - 1] = '#';
                    }
                    previousStone = 0;
                    unprocessed = j + 1;
                    break;
                case  '.':
                default:
                    break;
                }
            }
            for (; unprocessed < col - previousStone; ++unprocessed) {
                rotated[unprocessed][row - i - 1] = '.';
            }
            for (; unprocessed < col; ++unprocessed) {
                rotated[unprocessed][row - i - 1] = '*';
            }
        }
        return rotated;
    }

}
