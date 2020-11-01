package com.leetcode.structure.tree;

public class ConstructBinaryTreeFromPreOrderAndPostOrder {
    private int[] pre;
    private int[] post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        int len =pre.length;
        return buildNode(0, len - 1, 0, len - 1);
    }

    public TreeNode buildNode(int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(pre[preLeft]);
        }

        TreeNode root = new TreeNode(pre[preLeft]);
        int rootVal = pre[preLeft + 1];
        int rootIndex = postLeft;
        while (post[rootIndex] != rootVal) {
            ++rootIndex;
        }
        final int range = rootIndex - postLeft;
        final int preIndex = preLeft + 1 + range;
        final int postIndex = postLeft + range;
        root.left = buildNode(preLeft + 1, preIndex, postLeft,  postIndex);
        root.right = buildNode(preIndex + 1, preRight, postIndex + 1, postRight - 1);

        return root;
    }

    public static void main(String[] args) {
        final int[] pre = {1, 2, 4, 5, 3, 6 ,7};
        final int[] post = {4, 5, 2, 6, 7, 3, 1};
        new ConstructBinaryTreeFromPreOrderAndPostOrder().constructFromPrePost(pre, post);
    }

}
