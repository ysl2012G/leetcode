package com.leetcode.chanllenge.leetcode234;

public class MaxNumberOfNiceDivisors {
    private static final int DIVIDEND = (int) 1e9 + 7;

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors == 1) {
            return 1;
        }
        if (primeFactors == 2) {
            return 2;
        }

        final int remain = primeFactors % 3;
        if (remain == 0) {
            final int power = primeFactors / 3;
            return (int) modPow(3, power);
        }
        if (remain == 1) {
            final int power = (primeFactors - 4) / 3;
            return (int) (modPow(3, power) * 4 % DIVIDEND);
        }

        final int power = (primeFactors - 2) / 3;
        return (int) (modPow(3, power) * 2 % DIVIDEND);
    }

    private long modPow(long base, long power) {
        if (power == 0) {
            return 1;
        }
        long res = 1;
        while (power != 0) {
            if ((power & 1) == 1) {
                res = (res * base) % DIVIDEND;
            }
            power >>= 1;
            base = (base * base) % DIVIDEND;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxNumberOfNiceDivisors().maxNiceDivisors(73));
    }
}
