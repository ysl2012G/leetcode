package com.leetcode.chanllenge.leetcode219;

public class ParitionIntoMinNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        final int[] count = new int[10];
        for (char ch : n.toCharArray()) {
            ++count[ch - '0'];
        }

        int hi = 0;
        for (int i = 9; i >= 0; --i) {
            if (count[i] != 0) {
                hi = i;
                break;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        System.out.println(new ParitionIntoMinNumberOfDeciBinaryNumbers().minPartitions("32"));
    }
}
