package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MiddleValue {
    public static long calcSumOfMedian(int[] a, int[] b) {
        int n = a.length;
        long ans = 0;
        int cnt = 0;
        int i = 0, j = 0;
        while(cnt <= n) {
            if(i == n) {
                if(cnt >= n - 1) {
                    ans += b[j];
                }
                j++;
                cnt++;
                continue;
            }
            if(j == n) {
                if(cnt >= n - 1) {
                    ans += a[i];
                }
                i++;
                cnt++;
                continue;
            }
            if(a[i] < b[j]) {
                if(cnt >= n - 1) {
                    ans += a[i];
                }
                i++;
            }
            else {
                if(cnt >= n - 1) {
                    ans += b[j];
                }
                j++;
            }
            cnt++;
        }
        return ans;


    }

    @Test
    public void test() {
        Assertions.assertEquals(11, calcSumOfMedian(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10}));
        Assertions.assertEquals(8, calcSumOfMedian(new int[]{-1, 2, 3, 7}, new int[]{3, 5, 8, 10}));
        Assertions.assertEquals(6, calcSumOfMedian(new int[]{1, 2, 3, 7}, new int[]{1, 3, 5, 8}));
    }
}
