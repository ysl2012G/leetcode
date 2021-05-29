package com.leetcode.chanllenge.leetcode230;

import java.util.Deque;
import java.util.LinkedList;

public class CarFleet2 {
    public double[] getCollisionTimes(int[][] cars) {
        final int num = cars.length;
        final double[] res = new double[num];
        final Deque<Integer> stack = new LinkedList<>();



        for (int i = num - 1; i >= 0; --i) {
            res[i] = -1.0d;
            final int p1 = cars[i][0];
            final int s1 = cars[i][1];
            while (stack.size() > 0) {
                final int j = stack.peekLast();

                final int p2 = cars[j][0];
                final int s2 = cars[j][1];

                // 速度比不上
                if (s1 <= s2 ) {
                    stack.pollLast();
                // 按顺序c1, c2, c3；c2 先碰上 c3, 所以c1 直接和c3 比时间
                } else if (res[j] > 0 && 1.0 * (p2 - p1) / (s1 - s2) >= res[j]) {
                    stack.pollLast();
                } else {
                    break;
                }
            }
            // 检测到当前可以碰撞
            if (stack.size() > 0) {
                final int k = stack.peekLast();
                final int p3 = cars[k][0];
                final int s3 = cars[k][1];

                res[i] = 1.0 * (p3 - p1) / (s1 - s3);
            }

            // 计算完毕后，加入索引到stack
            stack.addLast(i);
        }
        return res;
    }
}
