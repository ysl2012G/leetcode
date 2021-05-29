package com.leetcode.chanllenge.biweek.leetcode45;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SentenceSimilarity3 {
    public boolean areSentenceSimilar(String sentence1, String sentence2) {
        final Deque<String> words1 = new LinkedList<>(Arrays.asList(sentence1.split("\\s+", -1)));
        final Deque<String> words2 = new LinkedList<>(Arrays.asList(sentence2.split("\\s+", -1)));

        if (words1.size() > words2.size()) {
            return areSentenceSimilar(sentence2, sentence1);
        }

        while (!words1.isEmpty() && !words2.isEmpty() && words1.peekFirst().equals(words2.peekFirst())) {
            words1.pollFirst();
            words2.pollFirst();
        }

        while (!words1.isEmpty() && !words2.isEmpty() && words1.peekLast().equals(words2.peekLast())) {
            words1.pollLast();
            words2.pollLast();
        }

        return words1.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new SentenceSimilarity3().areSentenceSimilar("d T d ED uXW L U J n klIe", "d T d ED uXW L U J klIe"));
    }
}
