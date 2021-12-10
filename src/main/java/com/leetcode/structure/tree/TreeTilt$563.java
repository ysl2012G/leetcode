package com.leetcode.structure.tree;

public class TreeTilt$563 {
    private int totalTilts = 0;
    public int findTilt(TreeNode root) {
        this.totalTilts = 0;
        sum(root);
        return totalTilts;
    }

    public int sum(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        final int leftSum = sum(curr.left);
        final int rightSum = sum(curr.right);
        totalTilts += Math.abs(leftSum - rightSum);
        return curr.val + leftSum + rightSum;
    }
}
