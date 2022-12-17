package com.leetcode.structure.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplyStrings$43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        final int len1 = num1.length();
        final int len2 = num2.length();

        final int[] vals = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; --i) {
            for (int j = len2 - 1; j >= 0; --j) {
                final int i1 = i + j;
                final int i2 = i + j + 1;
                final int ans = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + vals[i2];
                vals[i1] += ans / 10;
                vals[i2] = ans % 10;
            }
        }

        final StringBuilder builder = new StringBuilder(len1 + len2);
        for (int i = 0; i < vals.length; ++i) {
            if (builder.length() != 0 || vals[i] != 0){
                builder.append(vals[i]);
            }
        }
        return builder.toString();
    }

    @Test
    public void test() {
        final MultiplyStrings$43 solution = new MultiplyStrings$43();
        Assertions.assertEquals("56088", solution.multiply("123", "456"));
    }
}
