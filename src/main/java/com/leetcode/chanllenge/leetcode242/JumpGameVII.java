package com.leetcode.chanllenge.leetcode242;

import java.util.ArrayList;
import java.util.List;

public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        final int LEN = s.length();
        if (s.charAt(LEN - 1) != '0') {
            return false;
        }

        int curr = 0;
        List<Integer> positions = new ArrayList<>();
        positions.add(0);
        for (int i = 1; i < LEN; ++i) {
            if (s.charAt(i) != '0') {
                continue;
            }
            int step = i - curr;
            if (step > maxJump) {
                return false;
            }
            positions.add(i);
            curr = i;
        }

        final int JUMP_LEN = positions.size();
        final boolean[] memo = new boolean[JUMP_LEN];
        memo[0] = true;
        for (int i = 1; i < JUMP_LEN; ++i) {
            for (int j = i; j >= 0; j--) {
                final int step = positions.get(i) - positions.get(j);
                if (step > maxJump) {
                    break;
                }
                if (memo[j] && step >= minJump && step <= maxJump) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[JUMP_LEN - 1];
    }

    public static void main(String[] args) {
        new JumpGameVII().canReach("01101110", 3, 5);
    }
}
