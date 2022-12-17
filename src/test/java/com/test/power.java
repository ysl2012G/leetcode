package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class power {
    public static long pow(int x, int y) {
        long ans = 1;
        long xx = x;
        while(y != 0) {
            if((y&1) == 1) {
                ans = ans * xx;
            }
            xx = xx * xx;
            y >>= 1;
        }
        return ans;

    }

    @Test
    public void test() {
        Assertions.assertEquals(5, pow(5,1));
        Assertions.assertEquals(27, pow(3,3));
        Assertions.assertEquals(64, pow(4,3));
    }

}
