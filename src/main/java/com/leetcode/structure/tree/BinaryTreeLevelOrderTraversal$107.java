package com.leetcode.structure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal$107 {
    private static final class NodeInfo {
        TreeNode node;
        int depth;
        NodeInfo(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levelOrderedLists = new LinkedList<>();
        if (root == null) {
            return levelOrderedLists;
        }

        Queue<NodeInfo> searchNode = new LinkedList<>();
        int currentDepth = 1;
        searchNode.add(new NodeInfo(root, currentDepth));
        levelOrderedLists.push(new LinkedList<>());
        while(!searchNode.isEmpty()) {
            NodeInfo info = searchNode.poll();
            final TreeNode node = info.node;
            final int depth = info.depth;
            if (depth > currentDepth) {
                levelOrderedLists.push(new LinkedList<>());
                currentDepth = depth;
            }
            levelOrderedLists.peek().add(node.val);
            if (node.left != null) {
                searchNode.add(new NodeInfo(node.left, depth + 1));
            }
            if (node.right != null) {
                searchNode.add(new NodeInfo(node.right, depth + 1));
            }
        }
        return levelOrderedLists;
    }
}
