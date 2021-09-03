package com.leetcode.structure.tree;

import java.util.HashMap;
import java.util.Map;

public class MaxProductOfSplittedBinaryTree$1339 {
    private Map<TreeNode, Integer> cache;

    public int maxProduct(TreeNode root) {
        this.cache = new HashMap<>();
        final int totalSum = dfs(root.left) + dfs(root.right) + root.val;

        long max = 0;
        final int MODULE = (int) 1e9 + 7;

        for (Map.Entry<TreeNode, Integer> entry : cache.entrySet()) {
            final long sum = entry.getValue();
            max = Math.max(max, sum * (totalSum - sum));
        }

        return (int) (max % MODULE);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        cache.put(node, node.val + dfs(node.left) + dfs(node.right));
        return cache.get(node);
    }

}
