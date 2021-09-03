package com.leetcode.structure.arrays;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray$384 {
    private final int[] original;
    private final int len;

    private final Random random;
    public ShuffleAnArray$384(int[] nums) {
        this.original = nums;
        this.len = nums.length;
        this.random = new Random();
    }

    /** Returns a random shuffling of the array. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        final int[] shuffle = Arrays.copyOf(original, len);
        for (int i = 0; i < len - 1; ++i) {
            final int randomIndex = i + random.nextInt(len - i);

            final int temp = shuffle[i];
            shuffle[i] = shuffle[randomIndex];
            shuffle[randomIndex] = temp;
        }

        return shuffle;
    }


}
