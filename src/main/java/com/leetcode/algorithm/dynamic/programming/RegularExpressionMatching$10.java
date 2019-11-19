package com.leetcode.algorithm.dynamic.programming;

public class RegularExpressionMatching$10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return  false;
        }

        int sLen = s.length();
        int pLen = p.length();
        boolean[][] demo = new boolean[sLen + 1][pLen + 1];
        demo[0][0] = true;
        for (int i = 0; i <= sLen; i++){
            for (int j = 1; j <= pLen; j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    demo[i][j] = demo[i][j -2] || (i > 0 && demo[i - 1][j ]&&(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    demo[i][j] = i > 0 && demo[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                 }
            }
        }

        return demo[sLen][pLen];
    }



}
