package com.leetcode.chanllenge.leetcode212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        final List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; ++i) {
            res.add(isArithmetic(nums, l[i], r[i]));
        }
        return res;
    }

    private boolean isArithmetic(int[] nums, int left, int right) {
        if (right - left <= 1) {
            return true;
        }
        final int[] subs = Arrays.copyOfRange(nums, left, right + 1);
        int len = right - left + 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : subs) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        if ((max - min) % (len - 1) != 0) {
            return false;
        }
        final int interval = (max - min) / (len - 1);
        if (interval == 0) {
            return true;
        }
        for (int i = 0; i < len; ++i) {
            final int current = subs[i];
            if ((current - min) % interval != 0) {
                return false;
            }
            final int index = (current - min) / interval;
            if (index != i) {
                // swap
                final int temp = subs[index];
                if (temp == current) {
                    return false;
                }
                subs[index] = current;
                subs[i--] = temp;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final int[] nums = {1,2,10,-6,-7,8,16,0,0,10,20,15,-2,-3,-1,-4,-4,-8,-2};
        final int[] l = {14,5,11,15,12,13,9,7,0};
        final int[] r = {15,8,14,18,15,16,12,8,1};
        final long start = System.currentTimeMillis();
        new ArithmeticSubarrays().checkArithmeticSubarrays(nums, l, r);
        final long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
