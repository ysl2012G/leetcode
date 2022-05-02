package com.leetcode.algorithm.sort;

import java.util.Arrays;

public class OrderlyQueue$899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            final int len = s.length();

            String res = s;
            for (int i = 0; i < len; ++i) {
                final String curr = s.substring(i) + s.substring(0, i);

                if (curr.compareTo(res) < 0) {
                    res = curr;
                }
            }

            return res;
        }

        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
