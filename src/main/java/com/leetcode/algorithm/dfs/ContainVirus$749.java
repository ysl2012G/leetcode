package com.leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainVirus$749 {
    private static class Region {
        private final Set<Integer> infected = new HashSet<>();
        private final Set<Integer> uninfectedNeighbos = new HashSet<>();
        private int requiredWalls = 0;
    }

    public int containVirus(int[][] isInfected) {
        final int rowLen = isInfected.length;
        final int colLen = isInfected[0].length;

        int result = 0;

        while (true) {
            final boolean[][] visited = new boolean[rowLen][colLen];
            final List<Region> spreadRegion = new ArrayList<>();
            for (int i = 0; i < rowLen; ++ i) {
                for (int j = 0; j < colLen; ++ j) {
                    if (isInfected[i][j] == 1 && ! visited[i][j]) {
                        final Region region = new Region();
                        dfs(isInfected, i, j, visited, region);

                        if (region.uninfectedNeighbos.size() > 0) {
                            spreadRegion.add(region);
                        }
                    }
                }
            }

            if (spreadRegion.isEmpty()) {
                break;
            }

            spreadRegion.sort(((o1, o2) -> o2.uninfectedNeighbos.size() - o1.uninfectedNeighbos.size()));

            final Region buildWallRegion = spreadRegion.remove(0);
            result += buildWallRegion.requiredWalls;

            for (int index : buildWallRegion.infected) {
                isInfected[index / colLen][index % colLen] = 2;
            }

            for (Region unhandledRegion : spreadRegion) {
                for (int index : unhandledRegion.uninfectedNeighbos) {
                    isInfected[index / colLen][index % colLen] = 1;
                }
            }
        }

        return result;
    }


    private void dfs(int[][] grid, int row, int col, boolean[][] visited, Region region) {
        final int rowLen = grid.length;
        final int colLen = grid[0].length;

        if (row < 0 || row >= rowLen || col < 0 || col >= colLen || grid[row][col] == 2) {
            return;
        }

        if (grid[row][col] == 0) {
            ++region.requiredWalls;
            region.uninfectedNeighbos.add(row * colLen + col);
            return;
        }

        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        region.infected.add(row * colLen + col);

        dfs(grid, row - 1, col, visited, region);
        dfs(grid, row + 1, col, visited, region);
        dfs(grid, row, col + 1, visited, region);
        dfs(grid, row, col - 1, visited, region);
    }

    @Test
    public void test() {
        final int[][] grid = {{0,1,0,0,0,0,0,1}, {0,1,0,1,0,0,0,1}, {0,0,0,0,0,0,0,1}};
        final ContainVirus$749 solution = new ContainVirus$749();
        Assertions.assertEquals(16, solution.containVirus(grid));
    }
}
