package com.leetcode.chanllenge.leetcode248;

/**
 * math
 */
public class CountGoodNumbers {
    public int countGoodNumbers(long n) {
        final int MOD = (int) 1e9 + 7;
        if (n == 1) { return 5; }
        long total = (n & 1) == 1 ? 5 : 1;
        n >>=1;
        long factor = 20;
        while (n != 0) {
            if ((n & 1) == 1) {
                total = (total * factor) % MOD;
            }
            n >>=1;
            factor = (factor * factor) % MOD;
        }

        return (int) (total % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new CountGoodNumbers().countGoodNumbers(50));
    }
}
