package com.leetcode.algorithm.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class WordSearchII$212 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class TrieNode {
        private boolean endLetter;
        private final TrieNode[] next = new TrieNode[26];
    }

    private TrieNode root;
    private Set<String> ans;
    private boolean[][] visited;
    private char[][] board;
    private int row;
    private int col;

    public List<String> findWords(char[][] board, String[] words) {
        initTrie(words);
        this.ans = new HashSet<>();

        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.visited = new boolean[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                final StringBuilder prefix = new StringBuilder();
                prefix.append(board[i][j]);
                final int ch = board[i][j] - 'a';
                visited[i][j] = true;
                backTrack(i, j, root.next[ch], prefix);
                visited[i][j] = false;
            }
        }

        return ans.stream().collect(Collectors.toList());
    }

    private void initTrie(String[] words) {
        root = new TrieNode();

        for (String word : words) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); ++i) {
                final int ch = word.charAt(i) - 'a';
                if (curr.next[ch] == null) {
                    curr.next[ch] = new TrieNode();
                }
                curr = curr.next[ch];
            }
            curr.endLetter = true;
        }
    }

    private void backTrack(int i, int j, TrieNode node, StringBuilder prefix) {
        if (node == null) {
            return;
        }
        if (node.endLetter) {
            ans.add(prefix.toString());
        }

        for (int[] direction : DIRECTIONS) {
            final int nextI = i + direction[0];
            final int nextJ = j + direction[1];
            if (isValidCell(nextI, nextJ) && !visited[nextI][nextJ]) {
                final int len = prefix.length();
                prefix.append(board[nextI][nextJ]);
                final int ch = board[nextI][nextJ] - 'a';
                visited[nextI][nextJ] = true;
                backTrack(nextI, nextJ, node.next[ch], prefix);
                prefix.delete(len, prefix.length());
                visited[nextI][nextJ] = false;
            }
        }
    }

    private boolean isValidCell(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    @Test
    public void test() {
        final char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        final String[] words = {"oa", "oaa"};

        final WordSearchII$212 solution = new WordSearchII$212();
        solution.findWords(board, words).forEach(System.out::println);
    }
}
