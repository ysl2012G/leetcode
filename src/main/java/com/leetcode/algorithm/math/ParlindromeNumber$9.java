package com.leetcode.algorithm.math;

public class ParlindromeNumber$9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }

        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x = x / 10;
        }

        return x == revertNum || x == revertNum / 10;
    }

}
