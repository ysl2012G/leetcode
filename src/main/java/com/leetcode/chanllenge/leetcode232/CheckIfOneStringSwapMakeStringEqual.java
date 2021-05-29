package com.leetcode.chanllenge.leetcode232;

import java.util.ArrayList;
import java.util.List;

public class CheckIfOneStringSwapMakeStringEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        final List<Integer> indexes = new ArrayList<>();
        int len = s1.length();
        for (int i = 0; i < len; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                indexes.add(i);
                if (indexes.size() > 2) {
                    return false;
                }
            }
        }
        if (indexes.isEmpty()) {
            return true;
        }
        if (indexes.size() == 1) {
            return false;
        }
        final int first = indexes.get(0);
        final int second = indexes.get(1);

        return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }

    public static void main(String[] args) {
        new CheckIfOneStringSwapMakeStringEqual().areAlmostEqual("bank", "kanb");
    }
}
