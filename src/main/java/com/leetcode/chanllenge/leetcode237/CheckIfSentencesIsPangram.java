package com.leetcode.chanllenge.leetcode237;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckIfSentencesIsPangram {
    public boolean checkIfPangram(String sentence) {
        final Set<Integer> symbols = IntStream.range(0, 26).mapToObj(i -> i).collect(Collectors.toSet());;

        for (char ch : sentence.toCharArray()) {
            symbols.remove(ch - 'a');
        }

        return symbols.isEmpty();
    }
}
