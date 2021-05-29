package com.leetcode.chanllenge.leetcode234;

public class MinOps2ReinitializePermutation {

	public int reinitializePermutation(int n) {
		if (n == 2) {
			return 1;
		}

		final int mid = n >> 1;

		int step = 0;
		int curr = 1;

		while (curr != mid) {
			if (curr < mid) {
				curr <<= 1;
			} else {
				curr = (curr << 1) - n + 1;
			}
			++step;
		}
		return step + 1;
	}

	public static void main(String[] args) {
		System.out.println(new MinOps2ReinitializePermutation().reinitializePermutation(12));
	}
}
