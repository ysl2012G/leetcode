package com.leetcode.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckIfStringIsTransformableWithSubstringSortOperations$1585 {
    public boolean isTransformable(String s, String t) {
        final List<List<Integer>> idx =  new ArrayList<>(10);
        for (int i = 0; i < 10; ++i) {
            idx.add(new ArrayList<>());
        }

        final int len = s.length();
        for (int i = 0; i < len; ++i) {
            idx.get(s.charAt(i) - '0').add(i);
        }

        final int[] prevPos = new int[10];
        for (int i = 0; i < len; ++i) {
            final int digit = t.charAt(i) - '0';
            if (prevPos[digit] >=  idx.get(digit).size()) {
                return false;
            }

            for (int smaller = 0; smaller < digit; ++smaller) {
                if (prevPos[smaller] < idx.get(smaller).size() && idx.get(smaller).get(prevPos[smaller]) < idx.get(digit).get(prevPos[digit])) {
                    return false;
                }
            }
            ++prevPos[digit];
        }
        return true;
    }

    @Test
    void test() {
        final CheckIfStringIsTransformableWithSubstringSortOperations$1585 solution = new CheckIfStringIsTransformableWithSubstringSortOperations$1585();
        Assertions.assertTrue(solution.isTransformable("84532", "34852"));
    }
}
