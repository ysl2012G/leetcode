package com.leetcode.structure.string;

public class _6ZigzagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        if (numRows == 1) {
            return s;
        }

        StringBuilder sb  = new StringBuilder();
        int strLen = s.length();
		int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < strLen; j += step) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + step - i < strLen) {
                    sb.append(s.charAt(j + step - i));
                }
            }
        }
        return sb.toString();
    }

}
