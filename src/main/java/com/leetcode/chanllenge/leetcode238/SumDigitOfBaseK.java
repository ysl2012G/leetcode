package com.leetcode.chanllenge.leetcode238;

public class SumDigitOfBaseK {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n >= k) {
            sum += n % k;
            n /= k;
        }
        return sum + n;
    }

    public static void main(String[] args) {
        System.out.println(new SumDigitOfBaseK().sumBase(34, 6));
    }

}
