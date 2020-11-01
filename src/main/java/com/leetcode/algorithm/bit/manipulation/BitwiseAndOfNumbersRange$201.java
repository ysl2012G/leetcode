package com.leetcode.algorithm.bit.manipulation;

public class BitwiseAndOfNumbersRange$201 {
	public int rangeBitwiseAnd(int m, int n) {
		int moves = 0;
		int res = 0;
		while (m != 0 && n != 0) {
			int mBit = m & 0x1;
			int nBit = n & 0x1;
			if ((mBit ^ nBit) == 0) {
			    res += mBit << moves;
			} else {
			    res = 0;
			}
			m >>= 1;
			n >>= 1;
			moves++;
		}
		if ((m | n) != 0) {
		    res = 0;
        }
		return res;
	}

    public static void main(String[] args) {
        System.out.println(new BitwiseAndOfNumbersRange$201().rangeBitwiseAnd(5, 7));
    }
}
