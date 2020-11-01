package com.leetcode.chanllenge.leetcode210;

public class SplitTwoStringsToPalindrome {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int len = a.length();
        for (int i = 0, j = len - 1; i < len; ++i, --j) {
            if (a.charAt(i) != b.charAt(j)) {
                return isPalindrome(a, i ,j) || isPalindrome(b, i ,j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i , int j) {
        for (; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
