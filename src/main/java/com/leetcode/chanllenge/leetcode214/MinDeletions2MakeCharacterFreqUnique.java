package com.leetcode.chanllenge.leetcode214;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinDeletions2MakeCharacterFreqUnique {
    public int minDeletions(String s) {
        final int LEN = 26;
        final int[] freqs = new int[LEN];
        Arrays.fill(freqs, 0);
        for (char ch : s.toCharArray()) {
            freqs[ch - 'a']++;
        }
        Arrays.sort(freqs);
        int previous = freqs[LEN - 1];
        int deletions = 0;
        for (int i = LEN - 2; i >= 0; --i) {
            final int freq = freqs[i];
            if (freq == 0) {
                break;
            }
            if (freq >= previous) {
                final int currDeletes = freq - previous + 1;
                previous = Math.max(1, previous - 1);
                deletions += currDeletes;
            } else {
                previous = freqs[i];
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
//        System.out.println(new MinDeletions2MakeCharacterFreqUnique().minDeletions("abcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwz"));
        System.out.println(new MinDeletions2MakeCharacterFreqUnique().minDeletions("bbcebab"));
    }

}
