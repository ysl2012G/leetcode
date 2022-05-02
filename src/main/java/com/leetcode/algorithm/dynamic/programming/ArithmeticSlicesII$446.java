package com.leetcode.algorithm.dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSlicesII$446 {
    public int numberOfArithmeticSlices(int[] nums) {
        final int len = nums.length;
        if (len < 3) {
            return 0;
        }

        // ith index, total arithmetics info <diff, number> end at number ith index
        final List<Map<Integer, Integer>> cache = new ArrayList<>();

        int res = 0;
        for (int i = 0; i < len; ++i) {
            // 对于每个坐标i，创建一个map容器，记录key为diff的情况下，以坐标i为终点时可用的arithmetics slices
            cache.add(new HashMap<>());
            // 遍历每个小于i的坐标j，从而更新当前的map容器
            for (int j = 0; j < i; ++j) {
                long diff = (long) nums[i] - (long)nums[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                // 如果坐标i，j之前的diff之前不存在，即创建一个新的entr, key为diff，value为以当前坐标为重点的相同diff的数量
                int diffVal = (int) diff;
                // 对于小一些的坐标j, 初始化时为0
                final int arithmeticsAtJ = cache.get(j).getOrDefault(diffVal, 0);
                final int arithmeticsAtI = cache.get(i).getOrDefault(diffVal, 0);
                // 对于坐标i的slices更新，+=坐标j的slices数量+1，+1为需要包括坐标j的element
               cache.get(i).put(diffVal, arithmeticsAtI + arithmeticsAtJ + 1);

                // 对于结果，需要>=3个element，所以不能采用终点坐标为i的slices，
                // 这里累加终点坐标为j的slices原因为，当且仅当终点坐标为j的slices数量大于0，则表示在坐标j之前，还有相同的diff可以使用
                res += arithmeticsAtJ;
            }
        }

        return res;
    }
}

