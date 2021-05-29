package com.leetcode.chanllenge.leetcode231;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        boolean hasOnes = false;
        boolean previousOnes = false;
        for (char ch : s.toCharArray()) {
            if (ch == '1' ) {
                if (hasOnes && !previousOnes) {
                    return false;
                }
                hasOnes = true;
                previousOnes = true;
            } else {
                previousOnes = false;
            }
        }
        return true;
    }
}
