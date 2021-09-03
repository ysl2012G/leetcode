package com.leetcode.structure.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum$113 {
    private List<List<Integer>> paths;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.paths = new ArrayList<>();
        helper(root, new ArrayList<>(), targetSum);
        return paths;
    }

    private void helper(TreeNode root, List<Integer> path, int remainSum) {
        if (root == null) {
            return;
        }

        final int val = root.val;
        if (remainSum == val && root.left == null && root.right == null) {
            final List<Integer> curr = new ArrayList<>(path);
            curr.add(val);
            paths.add(curr);
        } else {
            final List<Integer> nextPath = new ArrayList<>(path);
            nextPath.add(val);
            helper(root.left, nextPath, remainSum - val);
            helper(root.right, nextPath, remainSum - val);
        }

    }
}
