package com.leetcode.structure.tree;

public class ConstructBinaryTreeFromPreOrderAndInOrder {
	private int[] preOrder;
	private int[] inOrder;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preOrder = preorder;
		this.inOrder = inorder;
		int len = preorder.length;
		return buildHelper(0, len - 1, 0, len - 1);
	}

	public TreeNode buildHelper(int inOrderLeft, int inOrderRight, int preOrderLeft, int preOrderRight) {
		if (inOrderLeft > inOrderRight) {
			return null;
		}
		if (inOrderLeft == inOrderRight) {
			return new TreeNode(inOrder[inOrderLeft]);
		}
		int rootVal = preOrder[preOrderLeft];
		TreeNode root = new TreeNode(rootVal);

		int rootIndex = inOrderLeft;
		while (inOrder[rootIndex] != rootVal) {
			++rootIndex;
		}

		int preIndex = preOrderLeft + rootIndex - inOrderLeft;

		root.left = buildHelper(inOrderLeft, rootIndex - 1, preOrderLeft + 1, preIndex);
		root.right = buildHelper(rootIndex + 1, inOrderRight, preIndex + 1, preOrderRight);
		return root;
	}
}
