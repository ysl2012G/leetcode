package com.leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder$127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> visited = new HashSet<>(wordList);
        if (!visited.contains(endWord)) { return 0; }

        final int WORD_LEN = beginWord.length();
        // string -> combinartion of words that can be formed;
        // key: virtual word e.g. d*g,*og,do*
        // value: acutal word
        final Map<String, List<String>> combDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < WORD_LEN; ++i) {
                final String virtualWord = word.substring(0, i) + '*' + word.substring(i + 1);
                final List<String> combWords = combDict.computeIfAbsent(virtualWord, k -> new ArrayList<>());
                combWords.add(word);
            }
        }


        final Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int res = 1;
        while (!queue.isEmpty()) {
            for (int step = queue.size(); step >0; --step) {
                final String word = queue.poll();
                for(int i = 0; i < WORD_LEN; ++i) {
                    final String virtualWord = word.substring(0, i) + '*' + word.substring(i + 1);
                    for (String adjacentWord : combDict.computeIfAbsent(virtualWord, k -> new ArrayList<>())) {
                        if (adjacentWord.equals(endWord)) {
                            return res + 1;
                        }
                        if (visited.remove(adjacentWord)) {
                            queue.add(adjacentWord);
                        }
                    }
                }
            }
            ++res;
        }

        return 0;
    }



    private Map<String, List<String>> combDict;
    public int ladderLengthBidirectionalBFS(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        final int WORD_LEN = beginWord.length();
        // string -> combinartion of words that can be formed;
        // key: virtual word e.g. d*g,*og,do*
        // value: acutal word
        this.combDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < WORD_LEN; ++i) {
                final String virtualWord = word.substring(0, i) + '*' + word.substring(i + 1);
                final List<String> combWords = combDict.computeIfAbsent(virtualWord, k -> new ArrayList<>());
                combWords.add(word);
            }
        }

        final Queue<String> beginQueue = new LinkedList<>();
        beginQueue.add(beginWord);
        final Map<String, Integer> beginVisited = new HashMap<>();
        beginVisited.put(beginWord, 1);

        final Queue<String> endQueue = new LinkedList<>();
        endQueue.add(endWord);
        final Map<String, Integer> endVisited = new HashMap<>();
        endVisited.put(endWord, 1);

        int beginLevel = 1;
        int endLevel = 1;
        while (!beginQueue.isEmpty() || !endQueue.isEmpty()) {
            if (!beginQueue.isEmpty()) {
                final int ans = updateSearch(beginQueue, beginVisited, endVisited, beginLevel++);
                if (ans != -1) {
                    return ans;
                }
            }
            if (!endQueue.isEmpty()) {
                final int ans =updateSearch(endQueue, endVisited, beginVisited, endLevel++);
                if (ans != -1) {
                    return ans;
                }
            }
        }

        return 0;
    }

    private int updateSearch(Queue<String> queue, Map<String, Integer> visited, Map<String, Integer> otherVisisted, int level) {
        for (int step = queue.size(); step > 0; --step) {
            final String word = queue.poll();
            for(int i = 0; i < word.length(); ++i) {
                final String virtualWord = word.substring(0, i) + '*' + word.substring(i + 1);
                final List<String> adjWords = combDict.get(virtualWord);
                if (adjWords == null) { continue; }
                for (String adjWord : adjWords) {
                    if (otherVisisted.containsKey(adjWord)) {
                        return level + otherVisisted.get(adjWord);
                    }
                    visited.computeIfAbsent(adjWord, k -> {
                        queue.add(adjWord);
                        return level + 1;
                    });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        final String beginWord = "hit";
//        final String endWord = "cog";
//        final List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        new WordLadder$127().ladderLength(beginWord, endWord, wordList);

        final String beginWord = "a";
        final String endWord = "c";
        final List<String> wordList = Arrays.asList("a", "b", "c");
        new WordLadder$127().ladderLengthBidirectionalBFS(beginWord, endWord, wordList);
//

    }
}
