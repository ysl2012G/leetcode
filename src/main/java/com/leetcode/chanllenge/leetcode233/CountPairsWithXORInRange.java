package com.leetcode.chanllenge.leetcode233;

public class CountPairsWithXORInRange {
    private static class TrieNode {
        int count;
        TrieNode[] next = new TrieNode[2];

        TrieNode() {
            this.count = 0;
        }
    }


    public int countPairs(int[] nums, int low, int high) {
        final TrieNode root = new TrieNode();
        int totalPairs = 0;

        for (int i = 0; i < nums.length; ++i) {
            totalPairs += getCounter(root, nums[i], high + 1) - getCounter(root, nums[i], low);
            insertNode(root, nums[i]);
        }
        return totalPairs;
    }

    private int getCounter(TrieNode root, int num, int target) {
        int count = 0;
        for (int i = 31; i >= 0 && root != null; --i) {
            final int numBit = (num >> i) & 1;
            final int targetBit = (target >> i) & 1;

            if (targetBit == 1) {
                //  当前bit为相同的必然可选，因为相同bit 异或结果为0，小于target
                if (root.next[numBit] != null) {
                    // 只获取小于target的数量
                    count += root.next[numBit].count;
                }
                // 当前bit相反的不一定可选，需迭代讨论， 异或结果为1 == target
                root = root.next[1 - numBit];
            } else {
                // 当前bit只能为相同，异或结果为0 == target
                root = root.next[numBit];
            }
        }
        return count;
    }


    private void insertNode(TrieNode root, int num) {
        for (int i = 31; i >= 0; --i) {
            int bit = (num >> i) & 1;
            if (root.next[bit] == null) {
                root.next[bit] = new TrieNode();
            }
            ++root.next[bit].count;
            root = root.next[bit];
        }
    }
}
