package com.leetcode.structure.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaxPathSum$124 {
	private Map<TreeNode, Integer> sumCache;
	private int res;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		res = Integer.MIN_VALUE;
		sumCache = new HashMap<>();
		dfs(root);
		return res;
	}

	private int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (sumCache.containsKey(node)) {
			return sumCache.get(node);
		}
		int left = Math.max(dfs(node.left), 0);
		int right = Math.max(dfs(node.right), 0);
		res = Math.max(res, left + right + node.val);
		int nodeSum = Math.max(left, right) + node.val;
		sumCache.put(node, nodeSum);
		return nodeSum;
	}

	private int[] arr;
	private int len;
	public boolean isValidSequence(TreeNode root, int[] arr) {
		if (root == null) {
		    return false;
		}
		this.arr = arr;
		this.len = arr.length;
		return dfs(root, 0);
	}

	private boolean dfs(TreeNode node, int pos) {
        if (node == null ) {
            return pos == len ;
        }
        if (pos > len ) {
            return false;
        }
        if (node.val != arr[pos]) {
            return false;
        }
        if (pos == len) {
            return node.left == null && node.right == null;
        }

        boolean left = dfs(node.left, pos + 1);
        boolean right = dfs(node.right, pos + 1);
        return left || right;
    }

}
