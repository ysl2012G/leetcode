package com.leetcode.structure.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaxPathSum$124 {
    private Map<TreeNode, Integer> cache;
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        cache = new HashMap<>();
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        final Integer current = cache.get(node);
        if (current != null) {
            return current;
        }

        final int leftMax = Math.max(dfs(node.left), 0);
        final int rightMax = Math.max(dfs(node.right), 0);
        maxSum = Math.max(maxSum, leftMax + rightMax + node.val);

        final int nodeMax = Math.max(leftMax, rightMax) + node.val;
        cache.put(node, nodeMax);
        return nodeMax;
    }

}
