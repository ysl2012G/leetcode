package com.leetcode.chanllenge.leetcode230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingRules {
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		final int counter;
		switch (ruleKey) {
			case "type":
				counter = (int) items.stream().filter(item -> item.get(0).equals(ruleValue)).count();
				break;
			case "color":
				counter = (int) items.stream().filter(item -> item.get(1).equals(ruleValue)).count();
				break;
			case "name":
				counter = (int) items.stream().filter(item -> item.get(2).equals(ruleValue)).count();
				break;
			default:
				counter = 0;
				break;
		}
		return counter;
	}

    public static void main(String[] args) {
        final List<String>  item =Arrays.asList("qqqq", "qqqq", "qqqq");
        final List<List<String>> items = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {
            items.add(item);
        }

        new CountItemsMatchingRules().countMatches(items, "name", "qqqq");
    }
}
