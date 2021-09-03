package com.leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder$128 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return Collections.emptyList();
		}

		final int WORD_LEN = beginWord.length();

        final Queue<List<String>> paths = new LinkedList<>();
        final List<String> beginPath = new LinkedList<>();
        beginPath.add(beginWord);
        paths.add(beginPath);

        final Set<String> words = new HashSet<>(wordList);
        // visited on the same level
        // 上一层出现的，下一层就不应该出现，否则就不可能是最短路径
        final Set<String> visited = new HashSet<>();
        final List<List<String>> res = new ArrayList<>();

        final Map<String, List<String>> adjDicts = new HashMap<>();
        while (!paths.isEmpty() && res.isEmpty()) {
            words.removeAll(visited);
            visited.clear();
            adjDicts.clear();

            for (String word : words) {
                for (int i = 0; i < WORD_LEN; ++i) {
                    final String virtualWord = word.substring(0, i) + '*' + word.substring(i + 1);
                    final List<String> adjWords = adjDicts.computeIfAbsent(virtualWord, k -> new ArrayList<>());
                    adjWords.add(word);
                }
            }

            for (int step = paths.size(); step > 0; --step) {
                final List<String> path = paths.poll();
                final String last = path.get(path.size() - 1);

                for (int i = 0; i < WORD_LEN; ++i) {
                    final String virtualWord = last.substring(0, i) + '*' + last.substring(i + 1);
                    final List<String> adjWords = adjDicts.get(virtualWord);
                    if (adjWords == null) { continue; }
                    for (String adjWord : adjWords) {
                        final List<String> curr = new LinkedList<>(path);
                        curr.add(adjWord);
                        visited.add(adjWord);
                        if (adjWord.equals(endWord)) {
                            res.add(curr);
                        } else {
                            paths.add(curr);
                        }

                    }
                }
            }
        }

        return res;
	}

    public static void main(String[] args) {
		final String beginWord = "hit";
		final String endWord = "cog";
		final List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		new WordLadder$128().findLadders(beginWord, endWord, wordList);


    }
}
