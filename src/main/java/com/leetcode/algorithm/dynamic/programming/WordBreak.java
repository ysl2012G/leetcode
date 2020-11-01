package com.leetcode.algorithm.dynamic.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 140
 */
public class WordBreak {
    private Map<String, List<String>> cache;
    private Set<String> dict;

    public List<String> wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();
        dict = new HashSet<>(wordDict);
        return dfs_helper(s);
    }

    private List<String> dfs_helper(String leftStr) {
        if (cache.containsKey(leftStr)) {
            return cache.get(leftStr);
        }
        if (leftStr.isEmpty()) {
            return Collections.singletonList("");
        }

        final List<String> sentences = new ArrayList<>();
        for(String word : dict) {
            if (!leftStr.startsWith(word)) {
                continue;
            }

            List<String> leftBreaks = dfs_helper(leftStr.substring(word.length()));
            for (String leftBreak : leftBreaks) {
                final String splitStr = leftBreak.isEmpty() ? "" : " ";
                final String sentence = String.format("%s%s%s", word, splitStr, leftBreak);
                sentences.add(sentence);
            }
        }
        cache.put(leftStr, sentences);
        return sentences;
    }
}
