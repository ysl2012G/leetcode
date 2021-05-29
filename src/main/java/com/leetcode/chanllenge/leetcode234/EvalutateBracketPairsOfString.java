package com.leetcode.chanllenge.leetcode234;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvalutateBracketPairsOfString {
    public String evaluate(String s, List<List<String>> knowledge) {

        final Map<String, String> cache = knowledge.stream().collect(Collectors.toMap(pairs -> pairs.get(0), pairs -> pairs.get(1)));

        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            final char ch = s.charAt(i);
            if (ch != '(') {
                builder.append(ch);
            } else {
                final int right = getRightBracketIndex(s, i);
                builder.append(cache.getOrDefault(s.substring(i + 1, right), "?"));
                i = right;
            }
        }
        return builder.toString();
    }


    private int getRightBracketIndex(String s, int left) {
        for (int i = left + 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                return i;
            }
        }
        throw new IllegalArgumentException("cannot find right brackets: " + s);
    }
}
