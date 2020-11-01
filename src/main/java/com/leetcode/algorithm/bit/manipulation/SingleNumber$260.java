package com.leetcode.algorithm.bit.manipulation;

public class SingleNumber$260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // find unique bit;
        xor &= -xor;

        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & xor) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
