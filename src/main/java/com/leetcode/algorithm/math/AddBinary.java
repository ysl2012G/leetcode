package com.leetcode.algorithm.math;

import java.util.Arrays;

public class AddBinary {
	public String addBinary(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		int len = Math.max(aLen, bLen) + 1;
		boolean[] res = new boolean[len];
		Arrays.fill(res, false);

		int index = 0;
		boolean carry = false;
		while (index < len) {
			final boolean aVal = (index < aLen) && (a.charAt(aLen - 1 - index) == '1');
			final boolean bVal = (index < bLen) && (b.charAt(bLen - 1 - index) == '1');
			final boolean addVal = aVal ^ bVal ^ carry;
			res[len - 1 - index] = addVal;
			carry =  (aVal && bVal) || (aVal && carry) || (bVal && carry);
			++index;
		}
		final StringBuilder binaryRes = new StringBuilder();
		boolean firstPositive = false;
        for (int i = 0; i < len; ++i) {
            if (firstPositive) {
                binaryRes.append(res[i] ? '1' : '0');
            } else if (res[i]) {
                binaryRes.append('1');
                firstPositive = true;
            }
        }
        if (!firstPositive) {
            return "0";
        }
        return binaryRes.toString();
	}

    public static void main(String[] args) {
        new AddBinary().addBinary("11", "1");
    }
}
