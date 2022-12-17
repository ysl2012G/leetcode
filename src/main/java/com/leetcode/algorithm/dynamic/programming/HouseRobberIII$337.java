package com.leetcode.algorithm.dynamic.programming;

import com.leetcode.structure.tree.TreeNode;

public class HouseRobberIII$337 {

    public int rob(TreeNode root) {
        final int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode curr) {
        if (curr == null) {
            return new int[2];
        }

        final int[] left = dfs(curr.left);
        final int[] right = dfs(curr.right);

        final int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = curr.val + left[0] + right[0];
        return res;
    }
}
