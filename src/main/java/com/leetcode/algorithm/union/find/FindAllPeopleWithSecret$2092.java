package com.leetcode.algorithm.union.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPeopleWithSecret$2092 {
    private static class UnionFind {
        private int[] root;
        private int[] size;

        UnionFind(int len) {
            this.root = new int[len];
            this.size = new int[len];
            for (int i = 0; i < len; ++i) {
                root[i] = i;
                size[i] = 1;
            }
        }

        int find(int p) {
            while (p != root[p]) {
                p = root[p];
            }
            return p;
        }

        void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            if (size[rootP] < size[rootQ]) {
                root[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                root[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
        }

        boolean hasSecret(int i) {
            return find(i) == find(0);
        }

        void reset(int i) {
            final int rootP = find(i);
            --size[rootP];
            root[i] = i;
            size[i] = 1;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        final UnionFind secrets = new UnionFind(n);
        secrets.union(0, firstPerson);
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[2]));
        final int len = meetings.length;

        int currTime = 0;
        Set<Integer> graphs = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            if (meetings[i][2] != currTime) {
                for (int person : graphs) {
                    if (!secrets.hasSecret(person)) {
                        secrets.reset(person);
                    }
                }

                currTime = meetings[i][2];
                graphs.clear();
            }
            secrets.union(meetings[i][0], meetings[i][1]);
            graphs.add(meetings[i][0]); graphs.add(meetings[i][1]);
        }
        final int rootP = secrets.find(0);
        final List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 1; i < n; ++i) {
            if (secrets.find(i) == rootP) {
                res.add(i);
            }
        }
        return res;
    }
}
