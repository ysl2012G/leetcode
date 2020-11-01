package com.leetcode.structure.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Leetcode 146
 */
public class LRUCache {
	private final Map<Integer, Integer> cache;
	private int capacity;

	public LRUCache(int capacity) {
		cache = new LinkedHashMap<>(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer val = cache.get(key);
		return val != null ? val : -1;
	}

	public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
        } else {
            if (cache.size() == capacity) {
                cache.remove(cache.keySet().iterator().next());
            }
            cache.put(key, value);
        }
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.get(2);
		cache.put(2, 6);
		cache.get(1);
		cache.put(1,5);
		cache.put(1,2);
        cache.get(1);
        cache.get(2);


	}

}
