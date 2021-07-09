package com.leetcode.algorithm.dynamic.programming;

public class CountVowelsPermutation$1220 {
    public int countVowelPermutation(int n) {
        final int MOD = (int) (1e9) + 7;
        long aCnt = 1;
        long eCnt = 1;
        long iCnt = 1;
        long oCnt = 1;
        long uCnt = 1;
        for (int i = 2; i <= n; ++i) {
            long aCntNew = (eCnt + iCnt + uCnt) % MOD;
            long eCntNew = (aCnt + iCnt) % MOD;
            long iCntNew = (eCnt + oCnt) % MOD;
            long oCntNew = (iCnt) % MOD;
            long uCntNew = (iCnt + oCnt) % MOD;


            aCnt = aCntNew;
            eCnt = eCntNew;
            iCnt = iCntNew;
            oCnt = oCntNew;
            uCnt = uCntNew;
        }

        final long res = (aCnt + eCnt + iCnt + oCnt + uCnt) % MOD;
        return (int) res;
    }
}
