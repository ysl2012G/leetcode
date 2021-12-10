package com.leetcode.chanllenge.leetcode267;

import org.junit.jupiter.api.Test;

public class ProcessRestrictedFriendRequests {
    private static final class UnionFind {
        private int[] parent;
        private int[] size;

        UnionFind(int len) {
            this.parent = new int[len];
            this.size = new int[len];
            for (int i = 0; i < len; ++i) {
                parent[i] = i;
                size[i] = 0;
            }
        }

        public void rebuild(UnionFind uf) {
            System.arraycopy(uf.parent, 0, this.parent, 0, this.parent.length);
            System.arraycopy(uf.size, 0, this.size, 0, this.size.length);
        }

        public int find(int p) {
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

            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }


    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        final int len = requests.length;
        final UnionFind friendUnion = new UnionFind(n);
        final boolean[] ans = new boolean[len];

        final UnionFind temp = new UnionFind(n);
        for (int i = 0; i < len; ++i) {
            final int p =  requests[i][0];
            final int q = requests[i][1];
            if (friendUnion.isConnected(p, q)) {
                ans[i] = true;
                continue;
            }

            temp.rebuild(friendUnion);
            temp.union(p, q);

            boolean couldUnion = true;
            for (int j = 0; j < restrictions.length; ++j) {
                final int restrictP = restrictions[j][0];
                final int restrictQ = restrictions[j][1];
                if (temp.isConnected(restrictP, restrictQ)) {
                    couldUnion = false;
                    break;
                }
            }
            if (couldUnion) {
                ans[i] = true;
                friendUnion.rebuild(temp);
            }
        }

        return ans;
    }

    @Test
    public void test() {
        final ProcessRestrictedFriendRequests solution = new ProcessRestrictedFriendRequests();
        final int n = 5;
        final int[][] restrictions = {{0, 1}, {1, 2}, {2, 3}};
        final int[][] requests = {{0, 4}, {1, 2}, {3, 1}, {3, 4}};
        solution.friendRequests(n, restrictions, requests);
    }
}
