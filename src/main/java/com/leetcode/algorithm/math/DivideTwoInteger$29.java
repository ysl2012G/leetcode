package com.leetcode.algorithm.math;

public class DivideTwoInteger$29 {
    public int divide(int divided, int divisor) {
        if (divided == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isResultNegative = isResultNegative(divided, divisor);
        long modifiedDivided = Math.abs((long) divided);
        long modifiedDivisor = Math.abs((long) divisor);

        long count = 0;
        int maxShiftStep = getMaxShiftStep(modifiedDivided, modifiedDivisor);
        for (int i = maxShiftStep; i >= 0; i--) {
            long auxiDivisor = modifiedDivisor << i;
            if (modifiedDivided >= auxiDivisor) {
                count += 1 << i;
                modifiedDivided = modifiedDivided - auxiDivisor;
            }
        }
        return isResultNegative ? (int)-count : (int)count;
    }

    private boolean isResultNegative(int divided, int divisor) {
        boolean isNegative = (divided < 0);
        isNegative ^= (divisor < 0);
        return isNegative;
    }

    private int getMaxShiftStep(long divided, long divisor) {
        int shiftSteps = 0;
        for (; shiftSteps <= 30; shiftSteps ++) {
            divisor <<= 1;
            if (divided < divisor) {
                break;
            }
        }
        return shiftSteps;
    }

    public static void main(String[] args) {
        DivideTwoInteger$29 test = new DivideTwoInteger$29();
        System.out.println(test.divide(15, 3));
        System.out.println(test.divide(-8 , 3));
    }
}
