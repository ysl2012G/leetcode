package com.leetcode.chanllenge.leetcode213;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * create by shuanglin on 2020/11/1
 */
public class FirstBuildingYouCanReach {

     public int furthestBuilding(int[] heights, int bricks, int ladders) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int step = 0;
        int remainBricks = bricks;
        for (; step < heights.length - 1; ++step) {
            final int diff = heights[step + 1] - heights[step];
            if (diff <= 0) {
                continue;
            }

            priorityQueue.add(diff);
            if (priorityQueue.size() > ladders) {
                final int minDiff = priorityQueue.poll();
                remainBricks = remainBricks - minDiff;
                if (remainBricks < 0) {
                    break;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        final int[] heights = {4,12,2,7,3,18,20,3,19};
        System.out.println(new FirstBuildingYouCanReach().furthestBuilding(heights, 10 ,2));
    }
}
