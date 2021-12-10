package com.leetcode.algorithm.union.find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge$721 {
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
    }



    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final int accountNum = accounts.size();
        final UnionFind unionFind = new UnionFind(accountNum);

        final Map<String, Integer> emailMappings = new HashMap<>();

        for (int i = 0; i < accountNum; ++i) {
            final int accountInfoNum = accounts.get(i).size();

            for (int j = 1; j < accountInfoNum; ++j) {
                final String email = accounts.get(i).get(j);
                if (!emailMappings.containsKey(email)) {
                    emailMappings.put(email, i);
                } else {
                    unionFind.union(i, emailMappings.get(email));
                }
            }
        }

        final Map<Integer, TreeSet<String>> merges = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailMappings.entrySet()) {
            final String email = entry.getKey();
            final int accountId = unionFind.find(entry.getValue());
            if (!merges.containsKey(accountId)) {
                merges.put(accountId, new TreeSet<>());
            }
            merges.get(accountId).add(email);
        }

        final List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : merges.entrySet()) {
            final String accountName = accounts.get(entry.getKey()).get(0);
            final List<String> accountInfo = new ArrayList<>(entry.getValue());
            accountInfo.add(0, accountName);
            res.add(accountInfo);
        }
        return res;
    }
}
