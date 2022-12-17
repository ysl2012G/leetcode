package com.leetcode.algorithm.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestDuplicateSubstring$1044 {
    private static final long PRIME = (1L << 31) - 1;
    private static final long RADIX = 26;

    public String longestDupSubstring(String s) {
        int left = 1;
        int right = s.length();

        int start = 0;
        int maxLen = 0;
        while (left < right) {
            int len = left + (right - left) / 2;
            boolean found = false;

            final Map<Long, List<Integer>> cache = new HashMap<>();
            long hash = hash(s, len);
            cache.put(hash, new ArrayList<>());
            cache.get(hash).add(0);

            long RM = 1L;
            for (int i = 1; i < len; ++i) {
                RM = (RM * RADIX) % PRIME;
            }

            loop:
            for (int i = 1; i + len <= s.length(); ++i) {
                hash = (hash + PRIME - RM * s.charAt(i - 1) % PRIME) % PRIME;
                hash = (hash * RADIX + s.charAt(i + len - 1)) % PRIME;

                if (!cache.containsKey(hash)) {
                    cache.put(hash, new ArrayList<>());
                } else {
                    for (int j : cache.get(hash)) {
                        if (compare(s, i, j, len)) {
                            found = true;
                            start = i;
                            maxLen = len;
                            break loop;
                        }
                    }
                }
                cache.get(hash).add(i);
            }
            if (found) {left = len + 1;}
            else {
                right = len;
            }
        }


        return s.substring(start, start + maxLen);
    }

    private long hash(String s, int len) {
        long hash = 0;
        for (int i = 0; i < len; ++i) {
            hash = (RADIX * hash + s.charAt(i)) % PRIME;
        }
        return hash;
    }

    private boolean compare(String s, int i, int j, int len) {
        for (int count = 0; count < len; ++count) {
            if (s.charAt(i++) != s.charAt(j++)) {
                return false;
            }
        }
        return true;
    }
}
