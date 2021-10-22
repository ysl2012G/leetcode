package com.leetcode.structure.trie;

public class ImplementTrie$208 {

    private static class TrieNode {
        private final TrieNode[] next = new TrieNode[26];
        private boolean isEndLetter;

        public TrieNode(boolean isEndLetter) {
            this.isEndLetter = isEndLetter;
        }
    }

    private final TrieNode root;

    public ImplementTrie$208() {
        this.root = new TrieNode(false);
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); ++i) {
            final int ch = word.charAt(i) - 'a';
            if (curr.next[ch] == null) {
                curr.next[ch] = new TrieNode(i == word.length() - 1);
            }
            curr = curr.next[ch];
        }
        curr.isEndLetter = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); ++i) {
            final int ch = word.charAt(i) - 'a';
            if (curr.next[ch] == null) {
                return false;
            }
            curr = curr.next[ch];
        }
        return curr.isEndLetter;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); ++i) {
            final int ch = prefix.charAt(i) - 'a';
            if (curr.next[ch] == null) {
                return false;
            }
            curr = curr.next[ch];
        }
        return curr != null;
    }
}
