package com.leetcode.algorithm.dynamic.programming;

import com.leetcode.structure.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII$95 {
    public List<TreeNode> generateTrees(int n) {
        final LinkedList<TreeNode> ans = new LinkedList<>();
        ans.add(new TreeNode(1));
        int nextVal = 2;

        while (nextVal <= n) {
            int size = ans.size();
            for (int i = 0; i < size; ++i) {
                final TreeNode head = ans.poll();
                TreeNode curr = head;
                while (curr != null) {
                    final TreeNode right = curr.right;

                    final TreeNode added = new TreeNode(nextVal);
                    final TreeNode temp = new TreeNode(curr.val);
                    final TreeNode previous = cloneNode(head, temp);
                    final TreeNode next = cloneNode(right);

                    temp.right = added;
                    added.left = next;
                    ans.add(previous);

                    curr = right;
                }

                final TreeNode newHead = new TreeNode(nextVal);
                newHead.left = head;
                ans.add(newHead);

            }
            ++nextVal;
        }

        return ans;
    }

    private TreeNode cloneNode(TreeNode curr) {
        if (curr == null) {
            return null;
        }
        final TreeNode clone = new TreeNode(curr.val);
        clone.left = cloneNode(curr.left);
        clone.right = cloneNode(curr.right);
        return clone;
    }

    private TreeNode cloneNode(TreeNode begin, TreeNode end) {
        if (begin == null) {
            return null;
        }
        if (begin.val == end.val) {
            end.left = cloneNode(begin.left);
            return end;
        }

        final TreeNode clone = new TreeNode(begin.val);
        clone.left = cloneNode(begin.left, end);
        clone.right = cloneNode(begin.right, end);
        return clone;
    }

    public static void main(String[] args) {
        final int n = 3;
        new UniqueBinarySearchTreesII$95().generateTrees(n);
    }
}
