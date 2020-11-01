package com.leetcode.structure.string;

public class Atoi$8 {
	public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return  0;
        }
        int res = 0;
        boolean positive = true;
        char firstChar = str.charAt(0);
        if (Character.isDigit(firstChar)) {
            res += firstChar - '0';
        } else if (firstChar == '-') {
            positive = false;
        } else if (firstChar != '+') {
            return 0;
        }
        int strLen = str.length();
        for (int i = 1; i < strLen; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.digit(c, 10);
                if (outOfRange(res, digit, positive)) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + digit;
            } else {
                return positive ? res : -res;
            }
        }
        return positive ? res : -res;
    }

    private boolean outOfRange(int res, int add, boolean positive) {
	    int maxRes = Integer.MAX_VALUE / 10;
	    int maxAdd;
	    if (positive) {
	        maxAdd = Integer.MAX_VALUE % 10;
        }  else {
	        maxAdd = -(Integer.MIN_VALUE % 10);
        }
	    if (res < maxRes) {
	        return  false;
        }
        return res > maxRes || add > maxAdd;
    }

    public static void main(String[] args) {
        System.out.println(new Atoi$8().myAtoi("-91283472332"));
//        System.out.println(Character.digit('0', 10));
//        System.out.println(Integer.MAX_VALUE * 10);
//        System.out.println(Integer.MIN_VALUE % 10);
    }

}
