package com.leetcode.structure.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays$957 {
    int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }
        final int cellNum = 8;
        Map<String, Integer> caches = new HashMap<>();
        int remainDays = N;
        while (remainDays > 0) {
            caches.put(Arrays.toString(cells), remainDays--);
            int[] updatedCells = new int[cellNum];
            for (int i = 1; i < cellNum - 1; i++) {
                updatedCells[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
            }
            cells = updatedCells;
            if (caches.containsKey(Arrays.toString(cells))) {
                remainDays %= caches.get(Arrays.toString(cells)) - remainDays;
            }
        }
        return cells;
    }
}
