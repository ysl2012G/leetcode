package com.leetcode.algorithm.bit.manipulation;

public class SingleNumber$137 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0 ){
            return 0;
        }
        int one = 0;
        int two = 0;
        int three;
        for(int num: nums) {
            two |= one & num;
            one ^= num;
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
