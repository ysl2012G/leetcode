package com.leetcode.algorithm.math;

import java.util.ArrayList;
import java.util.Collections;

public class Roman2Integer$13 {
	public int romanToInt(String s) {
		int res = 0;
		ArrayList<Character> romans = new ArrayList<>();
		Collections.addAll(romans, 'I', 'V', 'X', 'L', 'C', 'D', 'M');
		int[] roman2Int = {1, 5, 10, 50, 100, 500, 1000};

		int sLen = s.length();
		int prev = -1;
		for (int i = 0; i < sLen; i++) {
			char current = s.charAt(i);
			int pos = romans.indexOf(current);
			if (prev == -1) {
			    prev = pos;
			    res += roman2Int[pos];
			    continue;
            }
			if (pos <= prev) {
                res += roman2Int[pos];
                prev = pos;
			} else {
				res += roman2Int[pos];
				res -= roman2Int[prev] * 2;
			}
		}
		return res;
	}

    public static void main(String[] args) {
        System.out.println(new Roman2Integer$13().romanToInt("MCMXCIV"));
    }
}
