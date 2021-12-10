package com.leetcode.chanllenge.leetcode266;

import java.util.HashMap;
import java.util.Map;

public class CountVowelSubstringsOfString {
    public int countVowelSubstrings(String word) {
        final Map<Character, Integer> cache = new HashMap<>();
        cache.put('a', 0);
        cache.put('e', 0);
        cache.put('i', 0);
        cache.put('o', 0);
        cache.put('u', 0);

        int prev = 0;
        int k = 0;
        int vow = 0;
        int ans = 0;
        for (int i = 0; i < word.length(); ++i) {
            final char ch = word.charAt(i);
            if (cache.containsKey(ch)) {
                final int counter = cache.merge(ch, 0, (v1, v2) -> v1 + 1);
                if (counter == 1) {
                    ++vow;
                }
                while (vow == 5) {
                    final int counterAfterRemove = cache.merge(word.charAt(k), 0, (v1, v2) -> v1 - 1);
                    if (counterAfterRemove == 0) {
                        --vow;
                    }
                    ++k;
                }
                ans += k - prev;
            } else {
                cache.forEach((k1, v) -> cache.put(k1, 0));
                vow = 0;
                prev = i + 1;
                k = i + 1;
            }
        }
        return ans;
    }
}
