package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinationIterator$1286 {
    private final List<Integer> bitmasks;
    private final Iterator<Integer> iterator;
    final String characters;
    private final int len;
    public CombinationIterator$1286(String characters, int combinationLength) {
        this.characters = characters;
        this.len = characters.length();
        this.bitmasks = new ArrayList<>();
        backtrack(0, 0, combinationLength);
        this.iterator = bitmasks.iterator();
    }

    public String next() {
        int bitmask = iterator.next();
        final StringBuilder builder = new StringBuilder();
        int index = 0;
        while (bitmask != 0) {
            if ((bitmask & 1) != 0) {
                builder.append(characters.charAt(index));
            }
            bitmask >>= 1;
            ++index;
        }
        return builder.toString();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void backtrack(int curr, int index, int remainLen) {
        if (index > len || len - index < remainLen) {
            return;
        }
        if (remainLen == 0) {
            bitmasks.add(curr);
            return;
        }

        backtrack(curr | (1 << index), index + 1, remainLen - 1);
        backtrack(curr, index + 1, remainLen);
    }

    public static void main(String[] args) {

        final CombinationIterator$1286 solution = new CombinationIterator$1286("abc", 2);

    }

}
