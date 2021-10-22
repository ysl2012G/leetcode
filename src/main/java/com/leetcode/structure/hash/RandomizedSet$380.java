package com.leetcode.structure.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet$380 {

    private final List<Integer> values;
    private final Map<Integer,Integer> indexMap;
    private static final Random random = new Random();

    public RandomizedSet$380() {
        this.values = new ArrayList<>();
        this.indexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        final Integer index = indexMap.get(val);
        if (index == null) {
            return false;
        }

        final int len = values.size();
        if (index < values.size() - 1) {
            final int lastValue = values.get(len - 1);
            values.set(index, lastValue);
            indexMap.put(lastValue, index);
        }
        values.remove(len - 1);
        indexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
