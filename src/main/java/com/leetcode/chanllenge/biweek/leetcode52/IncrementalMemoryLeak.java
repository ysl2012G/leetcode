package com.leetcode.chanllenge.biweek.leetcode52;

public class IncrementalMemoryLeak {
    public int[] memLeak(int memory1, int memory2) {
        int crashTime = 1;
        while (memory1 >= crashTime || memory2 >= crashTime) {
            if (memory1 >= memory2) {
                memory1 -= crashTime;
            } else {
                memory2 -= crashTime;
            }
            ++crashTime;
        }
        return new int[] {crashTime, memory1, memory2};
    }
}
