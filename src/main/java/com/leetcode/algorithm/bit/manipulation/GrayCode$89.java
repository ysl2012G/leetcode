package com.leetcode.algorithm.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode$89 {
    public List<Integer> grayCode(int n) {
        final List<Integer> list = new ArrayList<>(1 << n);
        list.add(0);
        for (int i = 0; i < n; ++i) {
            for (int j = list.size() - 1; j >= 0; --j) {
                list.add(list.get(j) | (1 << i));
            }
        }
        return list;
    }
}
