package com.leetcode.chanllenge.leetcode239;

public class MinAdjacentSwapsToReachKthSmallestNumber {
    public int getMinSwaps(String num, int k) {
        final char[] nums = num.toCharArray();
        while (k-- > 0) {
            nextPermutation(nums);
        }
        return countSwaps(nums, num.toCharArray());
    }


    private void nextPermutation(char[] nums) {
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; --j) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        break;
                    }
                }
                reverse(nums, i + 1);
                break;
            }
        }
    }

    private void swap(char[] nums, int i, int j) {
        final char temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void reverse(char[] nums, int i) {
        int j = nums.length -1;
        while (i < j) {
            swap(nums, i++,j--);
        }
    }

    private int countSwaps(char[] current, char[] original) {
        final int LEN = current.length;
        int i = 0;
        int j = 0;
        int swaps = 0;

        while (i < LEN) {
            j = i;
            while (current[j] != original[i]) {
                ++j;
            }
            while (i < j) {
                swap(current, j, j - 1);
                --j;
                ++swaps;
            }
            ++i;
        }

        return swaps;
    }

    public static void main(String[] args) {
        final char[] nums = {'1', '2', '3'};
        final MinAdjacentSwapsToReachKthSmallestNumber solution = new MinAdjacentSwapsToReachKthSmallestNumber();
        solution.nextPermutation(nums);
    }

}
