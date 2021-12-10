package com.leetcode.algorithm.union.find;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor$952 {
    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int maxCount;
        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
            this.maxCount = 1;
        }

        private int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            // maker smaller root point to larger root
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                maxCount = Math.max(size[rootQ], maxCount);
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                maxCount = Math.max(size[rootP], maxCount);
            }
        }

        public int getMaxCount() { return maxCount; }
    }

    public int largestComponentSize(int[] nums) {
        final int len = nums.length;
        // Key:factor, value: node index
        final Map<Integer, Integer> cache = new HashMap<>();
        final UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; ++i) {
            int val = nums[i];
            for (int factor = 2; factor * factor <= val; ++ factor) {
                if (val % factor == 0) {
                    if (!cache.containsKey(factor)) {
                        cache.put(factor, i);
                    } else {
                        uf.union(i, cache.get(factor));
                    }
                    final int extraFactor = val / factor;
                    if (!cache.containsKey(extraFactor)) {
                        cache.put(extraFactor, i);
                    } else {
                        uf.union(i, cache.get(extraFactor));
                    }
                }
            }
            if (!cache.containsKey(val)) {
                cache.put(val, i);
            } else {
                uf.union(i, cache.get(val));
            }
        }
        return uf.getMaxCount();
    }
}
