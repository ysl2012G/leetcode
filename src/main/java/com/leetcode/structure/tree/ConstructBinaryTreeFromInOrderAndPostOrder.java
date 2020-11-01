package com.leetcode.structure.tree;

public class ConstructBinaryTreeFromInOrderAndPostOrder {

    private int[] inorder;
    private int[] postorder;
    private int len;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.len = inorder.length;
        this.inorder = inorder;
        this.postorder = postorder;
        return buildHelper(0, len - 1,0, len - 1);
    }

    private TreeNode buildHelper(int left, int right, int postLeft, int postRight) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(inorder[left]);
        }

        final int val = postorder[postRight];
        TreeNode root = new TreeNode(val);
        int inOrderIndex = left;
        while (inorder[inOrderIndex] != val) {
            ++inOrderIndex;
        }
        int postIndex = postLeft + inOrderIndex -left;

        root.left = buildHelper(left, inOrderIndex - 1, postLeft, postIndex - 1);
        root.right = buildHelper(inOrderIndex + 1, right,postIndex, postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {1,2,3,4,5};
        int[] postorder = {3,2, 5, 4, 1};
        new ConstructBinaryTreeFromInOrderAndPostOrder().buildTree(inorder, postorder);


    }
}
