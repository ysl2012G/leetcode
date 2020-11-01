package com.leetcode.chanllenge.leetcode199;

public class BulbSwitcher {
    public int minFlips(String target) {
        int len = target.length();
        int flips = 0;
        boolean initialState = true;
        boolean previousBulbState = false;
        for (int i = 0; i < len; i++) {
            char ch = target.charAt(i);
            if (ch == '0') {
                if (!initialState && previousBulbState) {
                    previousBulbState = false;
                    ++flips;
                }

            } else if (ch == '1') {
                if (initialState || !previousBulbState) {
                    initialState = false;
                    previousBulbState = true;
                    ++flips;
                }
            }
        }
        return flips;
    }

    public static void main(String[] args) {
        System.out.println(new BulbSwitcher().minFlips("0000000"));
    }
}
