package com.leetcode.structure.tree;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs$677 {

    private final TrieNode root;
    private final Map<String, Integer> cache;

    private static class TrieNode {
         private int val = 0;
         private TrieNode[] nextNodes = new TrieNode[26];

         public TrieNode(int val) {
             this.val = val;
         }
    }

    public MapSumPairs$677() {
        this.root = new TrieNode(0);
        this.cache = new HashMap<>();
    }

    public void insert(String key, int val) {
        final int delta = val - cache.getOrDefault(key, 0);
        cache.put(key, val);

        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            final int index = ch - 'a';

            if (curr.nextNodes[index] == null) {
                curr.nextNodes[index] = new TrieNode(delta);
            } else {
                curr.nextNodes[index].val += delta;
            }
            curr = curr.nextNodes[index];
        }
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            final int index = ch - 'a';
            if (curr.nextNodes[index] == null) {
                return 0;
            }
            curr = curr.nextNodes[index];
        }

        return curr.val;
    }

    public static void main(String[] args) {
        final MapSumPairs$677 sum = new MapSumPairs$677();
        sum.insert("apple", 3);
        sum.sum("apple");
    }
}
