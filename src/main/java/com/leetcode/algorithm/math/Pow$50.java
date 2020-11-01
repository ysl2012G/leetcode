package com.leetcode.algorithm.math;

public class Pow$50 {
    public double myPow(double x, int n) {
        if (n == 0) { return 1d; }
        if (Math.abs(x - 1d) < 1e-6) { return 1d;}
        boolean positive = n > 0;
        long power = Math.abs((long)n);
        double res = 1;
        while (power != 0) {
            if ((power & 1) == 1) {
                res *= x ;
            }
            x = x * x;
            power = power >> 1;
        }
        return positive ? res : 1 / res;
    }

    public static void main(String[] args) {
        System.out.println(new Pow$50().myPow(2d, 10));
    }
}
