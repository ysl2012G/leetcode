package com.leetcode.chanllenge.leetcode268;

import java.util.ArrayList;
import java.util.List;

public class SumOfKMirrorNumbers {
    public long kMirror(int k, int n) {
        int len = 1;
        final List<Long> res = new ArrayList<>();
        while (res.size() < n) {
            final char[] arr = new char[len];
            dfs(arr, k, 0, res);
            ++len;
        }
        final List<Long> sumList = res.subList(0, n);
        return sumList.stream().mapToLong(i -> i).sum();
    }

    private void dfs(char[] arr, int radix, int index, List<Long> res) {
        if (index >= (arr.length + 1) / 2) {
            final long base10Number = Long.parseLong(new String(arr), radix);
            final String base10Str = base10Number + "";
            boolean validNumber = true;
            for (int i = 0, j = base10Str.length() - 1; i < j; ++i, --j) {
                if (base10Str.charAt(i) != base10Str.charAt(j)) {
                    validNumber = false;
                    break;
                }
            }
            if (validNumber) {
                res.add(base10Number);
            }
            return;
        }

        for (int offset = 0; offset < radix; ++offset) {
            if (index == 0 && offset == 0) {
                continue;
            }
            arr[index] = (char) (offset + '0');
            arr[arr.length - 1 - index] = (char) (offset + '0');
            dfs(arr, radix, index + 1, res);
        }
    }
}
