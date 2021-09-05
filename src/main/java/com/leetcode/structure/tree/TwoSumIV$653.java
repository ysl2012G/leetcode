package com.leetcode.structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class TwoSumIV$653 {
    public boolean findTarget(TreeNode root, int k) {
        final Set<Integer> cache = new TreeSet<>();

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int number = queue.size();
            for (int i = 0; i < number; ++i) {
                final TreeNode node = queue.poll();
                cache.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        for (int val : cache) {
            final int remain = k - val;
            if (remain != val && cache.contains(remain)) {
                return true;
            }
        }
        return false;
    }
}
