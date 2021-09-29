package com.leetcode.algorithm.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumLengthOfConcatenatedStringwithUniqueCharacters$1239 {
    public int maxLength(List<String> arr) {
        final List<Integer> memo = new ArrayList<>();
        memo.add(0);
        int res = 0;
        for (String str : arr) {
            final int bits = getBits(str);
            if (bits == 0) {
                continue;
            }
            for (int i = memo.size() - 1; i >= 0; --i) {
                if ((memo.get(i) & bits) != 0 ) {
                    continue;
                }
                final int combBits = memo.get(i) | bits;
                memo.add(combBits);
                res = Math.max(res, Integer.bitCount(combBits));
            }
        }

        return res;
    }

    private int getBits(String str) {
        int ans = 0;
        for (char ch : str.toCharArray()) {
            final int bits = 1 << (ch - 'a');
            if ((ans & bits) != 0) {
                return 0;
            }
            ans = ans | bits;
        }
        return ans;
    }

    @Test
    public void test() {
        final List<String> arr = Arrays.asList("un","iq","ue");
        final MaximumLengthOfConcatenatedStringwithUniqueCharacters$1239 solution = new MaximumLengthOfConcatenatedStringwithUniqueCharacters$1239();

        Assertions.assertEquals(4, solution.maxLength(arr));

    }

}
