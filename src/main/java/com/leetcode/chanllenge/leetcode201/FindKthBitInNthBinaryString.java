package com.leetcode.chanllenge.leetcode201;

public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        final int midIndex = 1 << (n - 1);
        if (n == 1) {
            return '0';
        } else if (k == midIndex) {
            return '1';
        } else if (k < midIndex) {
            return findKthBit(n - 1, k);
        } else {
            int index = (midIndex << 1) - k;
            int reverseChar = findKthBit(n - 1, index);
            return reverseChar == '0' ? '1' : '0';
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindKthBitInNthBinaryString().findKthBit(4, 11));
    }
}
