package com.leetcode.algorithm.bit.manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberofValidWordsforEachPuzzle$1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        final Map<Integer, Integer> cache = new HashMap<>();
        for (String word : words) {
            cache.merge(bitmask(word), 1, (v1, v2) -> v1 + 1);
        }

        final List<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            final int first = 1 << (puzzle.charAt(0) - 'a');
            int sum = cache.getOrDefault(first, 0);

            int bitmask = bitmask(puzzle.substring(1));
            for (int submask = bitmask; submask > 0; submask = (submask - 1) & bitmask) {
                sum += cache.getOrDefault(submask | first, 0);
            }

            ans.add(sum);
        }

        return ans;
    }

    private int bitmask(String word) {
        int mask = 0;
        for (char ch : word.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }
        return mask;
    }

    @Test
    void test() {
        final NumberofValidWordsforEachPuzzle$1178 solution = new NumberofValidWordsforEachPuzzle$1178();
        final String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        final String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        Assertions.assertArrayEquals(new int[] {1,1,3,2,4,0}, solution.findNumOfValidWords(words, puzzles).stream().mapToInt(i -> i).toArray());

    }

}
