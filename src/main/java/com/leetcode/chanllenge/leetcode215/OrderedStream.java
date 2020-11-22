package com.leetcode.chanllenge.leetcode215;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private String[] values;
    private int ptr;
    public OrderedStream(int n) {
        values = new String[n];
        ptr = 0;
    }

    public List<String> insert(int id, String value) {
        final int index = id - 1;
        values[index] = value;
        int lastIndex = ptr;

        final List<String> result = new ArrayList<>();
        while (lastIndex < values.length && values[lastIndex] != null) {
            result.add(values[lastIndex++]);
        }

        ptr = lastIndex;
        return result;
    }
}
