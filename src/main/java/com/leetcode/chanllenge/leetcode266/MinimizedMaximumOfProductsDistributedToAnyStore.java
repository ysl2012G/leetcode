package com.leetcode.chanllenge.leetcode266;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    public int minimizedMaximum(int n, int[] quantities) {
        int lo = 1;
        int hi = 100_000;
        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;
            if(canDistributed(n, quantities, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }

    private boolean canDistributed(int n, int[] quantities, int target) {
        long ans = 0;
        for (int i = 0; i < quantities.length; ++i) {
            ans += (quantities[i] / target);
            if (quantities[i] % target != 0) {
                ++ans;
            }
        }

        return ans <= n;
    }
}
