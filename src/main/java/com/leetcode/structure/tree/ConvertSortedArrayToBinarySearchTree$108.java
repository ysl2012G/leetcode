package com.leetcode.structure.tree;

public class ConvertSortedArrayToBinarySearchTree$108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        final int mid = left + (right - left) / 2;
        final TreeNode node =  new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid);
        node.right = helper(nums, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
    }
}
