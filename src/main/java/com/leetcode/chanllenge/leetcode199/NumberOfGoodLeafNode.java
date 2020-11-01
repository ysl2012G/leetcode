package com.leetcode.chanllenge.leetcode199;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.leetcode.structure.tree.TreeNode;

public class NumberOfGoodLeafNode {
    private Map<TreeNode, Queue<Integer>> depths;
    private int count;
    private int distance;
    public int countPairs(TreeNode root, int distance) {
        if (distance == 0 ) {
            return 0;
        }
        count = 0;
        depths = new HashMap<>();
        this.distance = distance;
        findDepths(root);
        return count;
    }

    private Queue<Integer> findDepths(TreeNode node) {
        if (node == null) {
            return new PriorityQueue<>();
        }
        if (depths.containsKey(node)) {
            return depths.get(node);
        }
        Queue<Integer> left = findDepths(node.left);
        Queue<Integer> right = findDepths(node.right);

        if (!left.isEmpty() && !right.isEmpty()) {
            int leftMinDepth = left.peek();
            int rightMinDepth = right.peek();
            if (leftMinDepth + rightMinDepth <= distance) {
                 for (int leftDepth: left) {
                    for (int rightDepth : right) {
                        if (leftDepth + rightDepth <= distance){
                            ++count;
                        }
                    }
                }
            }
        }
        Queue<Integer> current = new PriorityQueue<>(Integer::compareTo);
		for (int leftDepth : left) {
			current.add(leftDepth + 1);
		}
		for (int rightDepth : right) {
			current.add(rightDepth + 1);
		}
        if (current.isEmpty()) {
            current.add(1);
        }
        if (current.peek() >= distance) {
            current.clear();
            current.add(distance);
        }
        depths.put(node, current);
        return current;
    }
}
