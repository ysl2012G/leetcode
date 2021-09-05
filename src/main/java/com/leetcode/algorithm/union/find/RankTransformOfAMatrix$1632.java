package com.leetcode.algorithm.union.find;

import java.util.*;

public class RankTransformOfAMatrix$1632 {

    private static class UnionFind {
        private final int[] id;
        private final Map<Integer, Set<Integer>> cache;

        public UnionFind(int n) {
            this.id = new int[n];
            Arrays.fill(id, -1);
            this.cache = new HashMap<>();
        }

        public int find(int p) {
            if (id[p] == -1) {
                final Set<Integer> connected = new HashSet<>();
                connected.add(p);
                cache.put(p, connected);
                id[p] = p;
                return p;
            }
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }
        
        public void union(int row, int col) {
            final int rootR = find(row);
            final int rootC = find(col);

            if (rootR == rootC) { return; }
            
            final Set<Integer> connectedR = cache.get(rootR);
            final Set<Integer> connectedC = cache.get(rootC);
            if (connectedR.size() < connectedC.size()) {
                id[rootR] = rootC;
                cache.remove(rootR);
                connectedC.addAll(connectedR);
            } else {
                id[rootC]= rootR;
                cache.remove(rootC);
                connectedR.addAll(connectedC);
            }
        }

        public List<Set<Integer>> getGroups() {
            return new ArrayList<>(cache.values());
        }
    }

    private static class Cell {
        private final int i;
        private final int j;
        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;

        final Map<Integer, Set<Cell>> values = new TreeMap<>();

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                final Set<Cell> cells = values.computeIfAbsent(matrix[i][j], k -> new HashSet<>());
                cells.add(new Cell(i, j));
            }
        }


        final int[][] ranks = new int[row][col];

        final int[] cacheRanks = new int[row + col];

        for (Set<Cell> cells : values.values()) {
            final UnionFind uf = new UnionFind(row + col);

            for (Cell cell : cells) {
                uf.union(cell.i, cell.j + row);
            }

            for (Set<Integer> group : uf.getGroups()) {
                int maxRank = 0;
                for (int index : group) {
                    maxRank = Math.max(maxRank, cacheRanks[index]);
                }
                for (int index : group) {
                   cacheRanks[index] = maxRank + 1;
                }
            }

            for (Cell cell : cells) {
                ranks[cell.i][cell.j] = cacheRanks[cell.i];
            }
        }

        return ranks;
    }

    public static void main(String[] args) {
        final int[][] matrix = { {1, 2}, {3, 4}};
        new RankTransformOfAMatrix$1632().matrixRankTransform(matrix);
    }
}
