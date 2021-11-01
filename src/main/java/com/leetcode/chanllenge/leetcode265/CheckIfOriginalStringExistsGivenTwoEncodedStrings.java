package com.leetcode.chanllenge.leetcode265;

public class CheckIfOriginalStringExistsGivenTwoEncodedStrings {

    private String s1;
    private String s2;
    private Boolean[][][] memo;

    public boolean possiblyEquals(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.memo = new Boolean[41][41][2000];

        return dfs(0, 0, 0);
    }

    private boolean dfs(int i1, int i2, int diff) {
        if (i1 >= s1.length() && i2 >= s2.length() && diff == 0) {
            return true;
        }
        if (memo[i1][i2][diff + 1000] != null) {
            return memo[i1][i2][diff + 1000];
        }

        boolean res = false;
        if (i1 < s1.length()) {
            if (Character.isDigit(s1.charAt(i1))) {
                int count = 0;
                int value = 0;
                while (i1 + count < s1.length() && count < 3 && Character.isDigit(s1.charAt(i1 + count))) {
                    value = 10 * value + (s1.charAt(i1 + count) - '0');
                    ++count;
                    if (dfs(i1 + count, i2, diff - value)) {
                        res = true;
                    }
                }
            } else {
                if (diff > 0) {
                    if (dfs(i1 + 1, i2, diff - 1)) {
                        res = true;
                    }
                } else if (diff == 0 && i2 < s2.length() && s1.charAt(i1) == s2.charAt(i2)) {
                    if (dfs(i1 + 1, i2 + 1, diff)) {
                        res = true;
                    }
                }
            }
        }
        if (i2 < s2.length()) {
            if (Character.isDigit(s2.charAt(i2))) {
                int count = 0;
                int value = 0;
                while (i2 + count < s2.length() && count < 3 && Character.isDigit(s2.charAt(i2 + count))) {
                    value = 10 * value + (s2.charAt(i2 + count) - '0');
                    ++count;
                    if (dfs(i1, i2 + count, diff + value)) {
                        res = true;
                    }
                }
            } else if (diff < 0 && dfs(i1, i2 + 1, diff + 1)){
                res = true;
            }
        }
        memo[i1][i2][diff + 1000] = res;
        return res;
    }
}
