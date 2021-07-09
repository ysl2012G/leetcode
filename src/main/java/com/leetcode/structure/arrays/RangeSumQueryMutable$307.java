package com.leetcode.structure.arrays;

public class RangeSumQueryMutable$307 {
    private int[] tree;
    private int size;

    public RangeSumQueryMutable$307(int [] nums) {
        this.size = nums.length;
        this.tree = new int[size * 2];
        buildTrees(nums);

    }

    private void buildTrees(int[] nums) {
        for (int i = size; i < 2 * size; ++i) {
            tree[i] = nums[i - size];
        }

        for (int i = size - 1; i > 0; --i) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        int pos = index + size;
        int diff = tree[pos] - val;
        tree[pos] = val;
        while (pos > 0) {
            tree[pos / 2] -= diff;
            pos = pos / 2;
        }
    }

    public int sumRange(int left, int right) {
        int leftPos = left + size;
        int rightPos = right + size;
        int sum = 0;
        while (leftPos <= rightPos) {
            if (leftPos % 2 == 1) {
                sum += tree[leftPos];
                ++leftPos;
            }
            if (rightPos % 2 == 0) {
                sum += tree[rightPos];
                --rightPos;
            }

            leftPos /= 2;
            rightPos /= 2;
        }
        return sum;
    }



//    private int[][] preSum;
//    private int blockSize;
//
//    public RangeSumQueryMutable$307(int[] nums) {
//        blockSize =(int) Math.ceil(Math.sqrt(nums.length));
//        preSum = new int[blockSize][blockSize + 1];
//
//        for (int i = 0; i < nums.length; ++i) {
//            final int blockIndex = i / blockSize;
//            final int slot = i % blockSize;
//            preSum[blockIndex][slot + 1] = preSum[blockIndex][slot] + nums[i];
//        }
//    }

//    public void update(int index, int val) {
//        final int blockIndex = index / blockSize;
//        final int slot = index % blockSize;
//
//        final int original = preSum[blockIndex][slot + 1] - preSum[blockIndex][slot];
//        final int diff = original - val;
//        for (int i = slot + 1; i <= blockSize; ++i) {
//            preSum[blockIndex][i] -= diff;
//        }
//    }
//
//    public int sumRange(int left, int right) {
//        final int leftBlockIndex = left / blockSize;
//        final int leftSlot = left % blockSize;
//
//        final int rightBlockIndex = right / blockSize;
//        final int rightSlot = right % blockSize;
//
//
//        if (leftBlockIndex == rightBlockIndex) {
//            return preSum[leftBlockIndex][rightSlot + 1] - preSum[leftBlockIndex][leftSlot];
//        }
//
//        int rangeSum = 0;
//        rangeSum += preSum[leftBlockIndex][blockSize] - preSum[leftBlockIndex][leftSlot];
//        rangeSum += preSum[rightBlockIndex][rightSlot + 1] - preSum[rightBlockIndex][0];
//
//        for (int index = leftBlockIndex + 1; index < rightBlockIndex; ++index) {
//            rangeSum += preSum[index][blockSize];
//        }
//
//        return rangeSum;
//    }


}
