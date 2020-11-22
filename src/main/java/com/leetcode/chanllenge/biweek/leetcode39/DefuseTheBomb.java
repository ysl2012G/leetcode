package com.leetcode.chanllenge.biweek.leetcode39;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int CODE_LEN = code.length;
        if (k == 0) {
            return new int[CODE_LEN];
        }
        int subLen = Math.abs(k);
        int subSum = 0;
        for (int i = 0; i < subLen; ++i) {
            subSum += code[i];
        }

        final int[] decrypt = new int[CODE_LEN];
        decrypt[CODE_LEN - 1] = subSum;
        for (int i = CODE_LEN - 2; i >= 0; --i) {
            int addIndex = (i + 1) % CODE_LEN;
            int subtractIndex = (i + subLen + 1) % CODE_LEN;
            subSum += code[addIndex] - code[subtractIndex];
            decrypt[i] = subSum;
        }
        if (k > 0) {
            return decrypt;
        } else {
            final int[] circularDecrpty = new int[CODE_LEN];
            for (int i = CODE_LEN - 1; i >=0; --i) {
                circularDecrpty[(i + subLen + 1) % CODE_LEN] = decrypt[i];
            }
            return circularDecrpty;
        }
    }

    public static void main(String[] args) {
        final int[] code = {2,4,9,3};
        final int k = -2;
        new DefuseTheBomb().decrypt(code, k);
    }
}
