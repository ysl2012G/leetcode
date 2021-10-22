package com.leetcode.algorithm.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharacterByFrequency$451 {
    public String frequencySort(String s) {
        final Map<Character, Integer> cache = new HashMap<>();

        for (char ch : s.toCharArray()) {
            cache.merge(ch, 1, (v1, v2) -> v1 + 1);
        }

        final List<Map.Entry<Character, Integer>> entries = new ArrayList<>(cache.entrySet());
        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            final char ch = entry.getKey();
            final int count = entry.getValue();
            for (int i = 0; i < count; ++i) {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
