package com.leetcode.chanllenge.leetcode199;

import java.util.Arrays;

public class StringCompression {
    private String s;
    private int len;
	private int[][] memo;
	private int[] compressLen;
	private int INF = 250;

	public int getLengthOfOptimalCompression(String s, int k) {
	    this.s = s;
	    this.len = s.length();

        compressLen = new int[101];
        compressLen[0] = 0;
        compressLen[1] = 1;
        for (int i = 2; i < 10; ++i) {
            compressLen[i] = 2;
        }
        for (int i = 10; i < 100; ++i) {
            compressLen[i] = 3;
        }
        compressLen[100] = 4;

        memo = new int[len][k + 1];
        for (int[] memoFragment : memo) {
            Arrays.fill(memoFragment, -1);
        }
        return solve(0, k);
    }

    private int solve(int left, int k) {
        if (k < 0) { return INF;}
        if (left >= len || len - left <= k) { return 0; }
        if (memo[left][k] != -1) { return memo[left][k]; }
        int res = INF;

        int[] letter = new int[26];
        for (int j = left, repeatedNum = 0; j < len; ++j) {
            repeatedNum = Math.max(repeatedNum, ++letter[s.charAt(j) - 'a']);
            int usedK = j - left + 1 - repeatedNum;
            res = Math.min(res, compressLen[repeatedNum] + solve(j + 1, k - usedK));
        }

        memo[left][k] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression().getLengthOfOptimalCompression("aaabcccd", 2));
    }
}
