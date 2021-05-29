package com.leetcode.chanllenge.leetcode239;

public class SplitStringIntoDescendingConsecutiveValues {
    public boolean splitString(String s) {
        return isDescendingValues(s, -1);

    }

    private boolean isDescendingValues(String s, long previous) {
        long current = 0;
        for (int i = 0; i < s.length(); ++i) {
            current = current * 10 + s.charAt(i) - '0';

            // overflow
            if (current >= (long) 1e10) {
                return false;
            }
            if (previous == -1) {
                if(isDescendingValues(s.substring(i + 1), current)) {
                    return true;
                }
            } else {
                if (current == previous - 1 && (i == s.length() -1 || isDescendingValues(s.substring(i + 1), current))) {
                    return true;
                }
            }
        }
        return false;
    }

}
