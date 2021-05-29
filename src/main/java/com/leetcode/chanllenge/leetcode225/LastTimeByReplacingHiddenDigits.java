package com.leetcode.chanllenge.leetcode225;

public class LastTimeByReplacingHiddenDigits {

    public String maximumTime(String time) {
        final char[] chars = time.toCharArray();

        final char UNDEFINED = '?';
        if (chars[0] == UNDEFINED) {
            if (chars[1] != UNDEFINED && chars[1] - '4' >= 0) {
                chars[0] = '1';
            } else {
                chars[0] = '2';
            }
        }
        if (chars[1] == UNDEFINED) {
            chars[1] = (chars[0] == '2') ? '3' : '9';
        }

        if (chars[3] == UNDEFINED) {
            chars[3] = '5';
        }

        if (chars[4] == UNDEFINED) {
            chars[4] = '9';
        }

        return new String(chars);

    }
}
