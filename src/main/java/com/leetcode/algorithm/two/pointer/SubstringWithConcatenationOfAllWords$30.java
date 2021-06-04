package com.leetcode.algorithm.two.pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords$30 {
    public List<Integer> findSubstring(String s, String[] words) {
        final int SLEN = s.length();
        final int WORDS_LEN = words.length;
        final int LEN = words[0].length();

        final Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.merge(word, 1, (oldVal, newVal) -> ++oldVal);
        }

        final List<Integer> res = new ArrayList<>();
        final Map<String, Integer> current = new HashMap<>(dict);
        for (int i = 0; i <= SLEN - WORDS_LEN * LEN; ++i) {
            current.clear();
            current.putAll(dict);
            for (int j = 0; j < WORDS_LEN; ++j) {
                final String word = s.substring(i + j * LEN, i + (j + 1) * LEN);
                if (current.containsKey(word)) {
                    current.computeIfPresent(word, (k, v) -> v > 1 ? -- v : null);
                } else {
                    break;
                }
            }
            if (current.isEmpty()) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        final String[] words = {"word","good","best","good"};
        new SubstringWithConcatenationOfAllWords$30().findSubstring("wordgoodgoodgoodbestword", words);
    }
}
