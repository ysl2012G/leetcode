package com.leetcode.chanllenge.leetcode238;

public class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        final int LEN = word.length();
        final int[] offsets = new int[LEN];
        for (int i = 0; i < LEN; ++i) {
            switch (word.charAt(i)) {
            case 'a':
                offsets[i] = 0;
                break;
            case 'e':
                offsets[i] = 1;
                break;
            case 'i':
                offsets[i] = 2;
                break;
            case 'o':
                offsets[i] = 3;
                break;
            case 'u':
                offsets[i] = 4;
                break;
            default:
                offsets[i] = -1;
                break;
            }
        }

        int res = 0;
        int leftBound = -1;
        int curr = 0;
        int prev = -1;

        while (curr < LEN) {
            final int offset = offsets[curr];
            if (prev == -1) {
                if (offset == 0) {
                    prev = offset;
                } else {
                    leftBound = curr;
                }
            } else {
                if (offset == prev || offset == prev + 1) {
                    prev = offset;
                    if (prev == 4) {
                        res = Math.max(res, curr - leftBound);
                    }
                } else {
                    if (offset == 0) {
                        leftBound = curr - 1;
                        prev = offset;
                    } else {
                        leftBound = curr;
                        prev = - 1;
                    }
                }
            }
            ++curr;
        }


        return res;
    }

    public static void main(String[] args) {

    }
}
