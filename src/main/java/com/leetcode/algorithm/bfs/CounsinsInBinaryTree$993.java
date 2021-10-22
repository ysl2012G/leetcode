package com.leetcode.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.structure.tree.TreeNode;

public class CounsinsInBinaryTree$993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int size = queue.size();
            boolean existX = false;
            boolean existY = false;

            for (int i = 0; i < size; ++i) {
                final TreeNode curr  = queue.poll();
                if (curr.val == x) { existX = true; }
                if (curr.val == y) { existY = true; }

                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }

                if (curr.left != null ) {
                    queue.offer(curr.left);
                }

                if (curr.right != null ) {
                    queue.offer(curr.right);
                }
            }
            if (existX && existY) {
                return true;
            }
        }
        return false;
    }
}
