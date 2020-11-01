package com.leetcode.algorithm.dynamic.programming;

/**
 * leetcode 70
 */
public class ClimbingStairs {
    public int clibStairs(int n) {
        if (n == 1) { return 1; }
        if (n == 2) { return 2; }
        int step1 = 1;
        int step2 = 2;
        int res = 0;
        for (int i = 2; i < n; ++i){
            res = step1 + step2;
            step1 = step2;
            step2 = res;
        }
        return res;
    }

    public boolean detectCapitalUse(String word) {
        if (word.isEmpty() || word.length() == 1) { return true; }
        int len = word.length();
        final boolean firstCapital = Character.isUpperCase(word.charAt(0));
        final boolean previousCapital = Character.isUpperCase(word.charAt(1));
        for (int i = 2; i < len; ++i) {
            if (previousCapital ^ Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return firstCapital || !previousCapital;
    }
}
