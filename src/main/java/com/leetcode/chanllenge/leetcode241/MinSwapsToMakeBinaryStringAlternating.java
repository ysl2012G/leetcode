package com.leetcode.chanllenge.leetcode241;

public class MinSwapsToMakeBinaryStringAlternating {
    public int minSwaps(String s) {
        final int LEN = s.length();
        int ones = 0;
        for (int i = 0; i < LEN; ++i) {
            if (s.charAt(i) == '1') {
                ++ones;
            }
        }
        int zeros = LEN - ones;
        if (Math.abs(ones - zeros) > 1) { return -1; }

        final String[] fields;
        if (ones > zeros) {
            return helper(s, '1');
        } else if (ones < zeros){
            return helper(s, '0');
        }

        return Math.min(helper(s, '1'), helper(s, '0'));
    }

    private int helper(String str, char firstChar) {
        int swaps = 0;
        char ch = firstChar;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ch) {
                ++swaps;
            }
            ch = (ch == '1') ? '0' : '1';
        }

        return swaps / 2;
    }

    public static void main(String[] args) {
        final String str = "10010011001";
        String[] fields = str.split("0+", -1);
        for (String field : fields) {
            System.out.println(field);
        }

    }
}
