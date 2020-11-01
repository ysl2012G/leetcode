package com.leetcode.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    private List<List<Integer>> res;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        boolean reversed = level % 2 == 1;
        if (level == res.size()) {
            res.add(new LinkedList<>());
        }
        if (reversed) {
            res.get(level).add(0, node.val);
        } else {
            res.get(level).add(node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

}
