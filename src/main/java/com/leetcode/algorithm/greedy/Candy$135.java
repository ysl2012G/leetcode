package com.leetcode.algorithm.greedy;

public class Candy$135 {
    public int candy(int[] ratings) {
        int res = 1;
        int currPeek = 1;
        int decreaseCount = 0;
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] < ratings[i -1]) {
                ++decreaseCount;
            } else {
                if (decreaseCount > 0) {
                    res += decreaseCount * (decreaseCount + 1) / 2;
                    if (decreaseCount >= currPeek) {
                        res += decreaseCount + 1 - currPeek;
                    }
                    decreaseCount = 0;
                    currPeek = 1;
                }
                currPeek = (ratings[i] == ratings[i - 1]) ? 1 : currPeek + 1;
                res += currPeek;
            }
        }

        if (decreaseCount > 0) {
            res += decreaseCount * (decreaseCount + 1) / 2;
            if (decreaseCount >= currPeek) {
                res += decreaseCount + 1 - currPeek;
            }
        }

        return res;
    }
}
