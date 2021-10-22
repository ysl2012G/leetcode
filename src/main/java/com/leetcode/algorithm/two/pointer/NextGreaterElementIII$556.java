package com.leetcode.algorithm.two.pointer;

public class NextGreaterElementIII$556 {
    public int nextGreaterElement(int n) {
        final int[] nums = new int[10];
        int index = 9;
        while (n != 0) {
            nums[index--] = n % 10;
            n /= 10;
        }

        for (int i = 8; i > index; --i) {
            if (nums[i + 1] > nums[i]) {
                int j = 9;
                for (; j > i; --j) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                swap(nums, i, j);
                reverse(nums, i + 1);
                return getRes(nums, index + 1);
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private int getRes(int[] nums, int i) {
        long ans  = 0;
        for (; i < nums.length; ++i) {
            ans *= 10;
            ans += nums[i];
        }
        return (ans <= Integer.MAX_VALUE) ? (int) ans : -1;
    }
}
