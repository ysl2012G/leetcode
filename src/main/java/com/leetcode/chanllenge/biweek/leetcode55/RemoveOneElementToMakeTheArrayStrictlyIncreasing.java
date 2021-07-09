package com.leetcode.chanllenge.biweek.leetcode55;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        int counter = 0;
        int prev = nums[0];
        int curr = nums[1];
        for (int i = 2; i < nums.length; ++i) {
            final int next = nums[i];
            if (curr <= prev || next <= curr) {
                if (counter > 0) {
                    return false;
                }

                if (next > prev) {
                    ++counter;
                    curr = next;
                } else if (curr > prev) {
                    ++ counter;
                } else if (curr < next) {
                    ++counter;
                    prev = curr;
                    curr = next;
                } else {
                    return false;
                }
            } else {
                prev = curr;
                curr = next;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final int nums[] = {100, 21, 100};
        new RemoveOneElementToMakeTheArrayStrictlyIncreasing().canBeIncreasing(nums);
    }
}
