package com.leetcode.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree$662 {
    private static final class NodeInfo{
        TreeNode node;
        int pos;
        NodeInfo(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
    int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res = 0;
        Queue<NodeInfo> levelNode = new LinkedList<>();
        levelNode.add(new NodeInfo(root, 1));
        while (!levelNode.isEmpty()) {
            if (levelNode.size() == 1) {
                levelNode.peek().pos = 1;
            }
            int startPos = levelNode.peek().pos;
            int currentPos = levelNode.peek().pos;
            int levelNum = levelNode.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = levelNode.peek().node;
                currentPos = levelNode.peek().pos;
                levelNode.poll();
                if (node.left != null) {
                    levelNode.add(new NodeInfo(node.left, 2 * currentPos));
                }
                if (node.right != null) {
                    levelNode.add(new NodeInfo(node.right, 2 * currentPos + 1));
                }
            }
            res = Math.max(currentPos - startPos + 1, res);
        }
        return res;
    }
}
