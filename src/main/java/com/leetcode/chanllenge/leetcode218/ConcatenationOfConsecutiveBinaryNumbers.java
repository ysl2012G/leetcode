package com.leetcode.chanllenge.leetcode218;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        final int DIVIDEND = (int) (1e9 + 7);

        int binaryLen = getBinaryLen(n);


        long result = 1;
        int stepLen = 2;
        int stepTimes = 2;

        for (int i = 2; i <= n; ++i) {
            result = (result << stepLen) + i;
            result %= DIVIDEND;

            if (--stepTimes == 0) {
                stepTimes = 1 << (stepLen++);
            }
        }
        return (int) (result % DIVIDEND);
    }

    private int getBinaryLen(int n ) {
        int len = 1;
        int res = n >> 1;
        while (res != 0) {
            res >>= 1;
            ++len;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(42));
    }
}
