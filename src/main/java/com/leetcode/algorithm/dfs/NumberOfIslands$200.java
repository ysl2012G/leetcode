package com.leetcode.algorithm.dfs;

public class NumberOfIslands$200 {

	private int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	private int colLen;
	private int rowLen;
	private boolean isValidPos(int i ,int j) {
        return i >= 0 && j >= 0 && i < rowLen && j < colLen;
    }

	public int numIslands(char[][] grid) {
		if (grid == null) {
			return 0;
		}
		rowLen = grid.length;
		if (rowLen == 0) {
			return 0;
		}
		colLen = grid[0].length;
		if (colLen == 0) {
			return 0;
		}
		int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen ; j++) {
                if (grid[i][j] <= '0') {
                    continue;
                }
                res ++;
                dfs(i, j, grid);
            }
        }
        return res;

	}

	private void dfs(int row, int col, char[][] grid) {
	    if (grid[row][col] <= '0') {
	        return;
        }
	    grid[row][col] = '0';
	    for (int[] move : moves) {
	        int nextRow = row + move[0];
	        int nextCol = col + move[1];
            if (isValidPos(nextRow, nextCol)) {
                dfs(nextRow, nextCol, grid);
            }
        }
    }
}
