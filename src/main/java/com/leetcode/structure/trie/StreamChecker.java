package com.leetcode.structure.trie;

/**
 * leetcode 1032
 */
public class StreamChecker {
    private static class TrieNode {
        private int val;
        private TrieNode[] next = new TrieNode[26];
        private boolean firstLetter;


        public TrieNode(int val) {
            this.val = val;
            this.firstLetter = false;
        }
    }

    private final TrieNode root = new TrieNode(0);
    private final StringBuilder builder = new StringBuilder();
    private int maxSize = 0;

    public StreamChecker(String[] words) {
        for (String word : words) {
            maxSize = Math.max(maxSize, word.length());
            TrieNode curr = root;
            for (int i = word.length() - 1; i >= 0; --i) {
                int val = word.charAt(i) - 'a';
                if (curr.next[val] == null) {
                    curr.next[val] = new TrieNode(val);
                }
                curr = curr.next[val];
            }
            curr.firstLetter = true;
        }

    }

    public boolean query(char letter) {
        if (builder.length() > maxSize) {
            builder.deleteCharAt(0);
        }
        builder.append(letter);

        TrieNode curr = root;
        for (int i = builder.length() - 1; i >= 0; --i) {
            final int val = builder.charAt(i) - 'a';
            if (curr.next[val] == null) {
                return false;
            }
            curr = curr.next[val];
            if (curr.firstLetter) {
                return true;
            }
        }
        return false;
    }
}
