package com.leetcode.structure.string;

public class String2Integer$8 {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();

        boolean hasValue = false;
        boolean positive = true;
        int res = 0;
        for (char c : str.toCharArray()) {
            if (isDigit(c)) {
                hasValue = true;
                int current = c - '0';
                if (inRange(res, positive, current)) {
                    res = res * 10 + current;
                } else {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                if (hasValue) {
                    break;
                } else {
                    if (isPlusOrMinus(c)) {
                        hasValue = true;
                        positive = c == '+';
                    } else if (!isBlank(c)) {
                        break;
                    }
                }
            }
        }

        return positive ? res : -res;
    }

    private boolean isPlusOrMinus(char c) {
        return c == '+' || c == '-';
    }

    private boolean isBlank(char c) {
        return c == ' ';
    }


    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean inRange(int result, boolean positive, int remain) {
        if (positive) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && remain > 7)) {
                return false;
            }
        } else {
            if (-result < Integer.MIN_VALUE / 10 || (-result == Integer.MIN_VALUE / 10 && -remain < -8)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new String2Integer$8().myAtoi("-2147483649"));
    }

}
