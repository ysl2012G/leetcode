package com.leetcode.structure.arrays;

public class RotateArray$189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;
        k = k % len;
        int count = 0;
        for (int start = 0; count < len; start++ ) {
            int currIndex = start;
            int preVal = nums[start];
            do {
                int nextIndex = (currIndex + k) % len;
                int temp = nums[nextIndex];
                nums[nextIndex] = preVal;
                preVal = temp;
                currIndex = nextIndex;
                count++;
            } while (currIndex != start);
        }
    }
}
