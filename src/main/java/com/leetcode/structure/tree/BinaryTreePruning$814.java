package com.leetcode.structure.tree;

public class BinaryTreePruning$814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1 ? root : null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null) {
            return root.val == 1 ? root : null;
        }
        return root;
    }
}
