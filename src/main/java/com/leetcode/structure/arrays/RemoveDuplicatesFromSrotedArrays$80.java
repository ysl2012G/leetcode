package com.leetcode.structure.arrays;

public class RemoveDuplicatesFromSrotedArrays$80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = 1;
        int leftVal = nums[left];
        boolean isParticular = true;
        int rightVal;
        for (; right < len; right++) {
            rightVal = nums[right];
            if (rightVal > leftVal) {
                nums[++left] = nums[right];
                leftVal = nums[left];
                isParticular = true;
            } else if (rightVal == leftVal && isParticular) {
                nums[++left] = nums[right];
                isParticular = false;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int length = new RemoveDuplicatesFromSrotedArrays$80().removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }

}
