package com.leetcode.structure.tree;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree$543 {
    private Map<TreeNode, Integer> depths;
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        depths = new HashMap<>();
        findDepth(root);
        return res;
    }

    private int findDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (depths.containsKey(node)) {
            return depths.get(node);
        }
        int left = findDepth(node.left);
        int right = findDepth(node.right);
        res = Math.max(left + right, res);
        int depth = Math.max(left, right) + 1;
        depths.put(node, depth);
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        root.right = new TreeNode(3);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        new DiameterOfBinaryTree$543().diameterOfBinaryTree(root);
    }

}
