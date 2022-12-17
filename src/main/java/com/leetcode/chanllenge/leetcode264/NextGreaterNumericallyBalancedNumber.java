package com.leetcode.chanllenge.leetcode264;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;

public class NextGreaterNumericallyBalancedNumber {

    public int nextBeautifulNumber(int n) {
        if (n == 0) { return 1; }
        final int strLen = (int) Math.floor(Math.log10(n) + 1);

        for (int len = strLen; len <= strLen + 1; ++len) {
            final List<Integer> out = new ArrayList<>();
            final Map<Integer, Integer> counter = new HashMap<>();
            backtrack(0, len, 0, counter, out);
			for (int num : out) {
				if (num > n) {
					return num;
				}
            }
        }
        return -1;
    }


    private void backtrack(int i, int numLen, int currNumber, Map<Integer, Integer> counter, List<Integer> out) {
        if (i == numLen) {
            boolean isBalancedNumber = true;
            for (Map.Entry<Integer,Integer> entry : counter.entrySet()) {
                if (entry.getValue() > 0 && !Objects.equals(entry.getKey(), entry.getValue())) {
                    isBalancedNumber = false;
                    break;
                }
            }
            if (isBalancedNumber) {
                out.add(currNumber);
            }
            return;
        }

        for (int digit = 1; digit <= numLen; ++digit) {
            final int currCounter = counter.getOrDefault(digit, 0);
            if (currCounter >= digit) {
                continue;
            }
            if (currCounter + numLen - i < digit) {
                continue;
            }

            counter.put(digit, currCounter + 1);
            backtrack(i + 1, numLen,  currNumber * 10 + digit, counter, out);
            counter.put(digit, currCounter);
        }
    }

    @Test
    public void test() {
        final NextGreaterNumericallyBalancedNumber solution = new NextGreaterNumericallyBalancedNumber();
        solution.nextBeautifulNumber(3000);
    }
}
