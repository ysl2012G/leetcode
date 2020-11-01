package com.leetcode.structure.tree;

public class ConstructBinaryTreeFromPreorder$1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        helper(root, preorder, 1, preorder.length - 1);
        return  root;
    }

    private void helper(TreeNode root, int[] preorder, int left, int right) {
        if (left> right) {
            return;
        }
        int val = root.val;
        int i = left;
        for (; i <= right; i++) {
            if (preorder[i] > val) {
                break;
            }
        }
        if (i > left ) {
            TreeNode leftNode = new TreeNode(preorder[left]);
            root.left = leftNode;
            helper(leftNode, preorder, left + 1, i - 1);
        }
        if (i < right + 1) {
            TreeNode rightNode = new TreeNode(preorder[i]);
            root.right = rightNode;
            helper(rightNode, preorder, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        new ConstructBinaryTreeFromPreorder$1008().bstFromPreorder(preorder);
    }
}
