package com.leetcode.structure.tree;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother$2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        final TreeNode lca = findLCA(root, startValue, destValue);
        final StringBuilder start = new StringBuilder();
        getPath(lca, startValue, start);
        final StringBuilder dest = new StringBuilder();
        getPath(lca, destValue, dest);
        for (int i = 0; i < start.length(); ++i) {
            dest.insert(0, 'U');
        }
        return dest.toString();
    }

    final boolean getPath(TreeNode curr, int targetValue, StringBuilder builder) {
        if (curr == null) {
            return false;
        }
        if (curr.val == targetValue) {
            return true;
        }
        builder.append('L');
        if (getPath(curr.left, targetValue, builder)) {
            return true;
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append('R');
        if (getPath(curr.right, targetValue, builder)) {
            return true;
        }
        builder.deleteCharAt(builder.length() - 1);
        return false;
    }

    private TreeNode findLCA(TreeNode curr, int startValue, int destvalue) {
        if (curr == null) {
            return null;
        }
        if (curr.val == startValue) {
            return curr;
        }
        if (curr.val == destvalue) {
            return curr;
        }
        final TreeNode left = findLCA(curr.left, startValue, destvalue);
        final TreeNode right = findLCA(curr.right, startValue, destvalue);
        if (left != null  && right != null) {
            return curr;
        }
        return left != null ? left : right;
    }
}
