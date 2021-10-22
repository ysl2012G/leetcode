package com.leetcode.algorithm.dfs;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.structure.tree.TreeNode;

public class PathSumIII$437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        final Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return dfs(root, 0, targetSum, preSum);
    }

    private int dfs(TreeNode curr, int currSum, int target, Map<Integer, Integer> preSum) {
        if (curr == null) {
            return 0;
        }

        currSum += curr.val;

        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.merge(currSum, 1, (v1, v2) -> v1 + 1);

        res += dfs(curr.left, currSum, target, preSum) + dfs(curr.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);

        return res;
    }
}
