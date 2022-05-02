package com.leetcode.algorithm.geometry;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ErrectTheFence$587 {
    private static class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private int getOrientation(Point first, Point second, Point third) {
        return (third.y - second.y) * (second.x - first.x) - (second.y - first.y) * (third.x - second.x);
    }

    public int[][] outerTrees(int[][] trees) {
        final int len = trees.length;
        final Point[] points = new Point[len];
        for (int i = 0; i < len; ++i) {
            points[i] = new Point(trees[i][0], trees[i][1]);
        }

        Arrays.sort(points, Comparator.comparingInt(Point::getX).thenComparingInt(Point::getY));

        // search bottom
        final Deque<Integer> bottomIndex = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            while (bottomIndex.size() >= 2) {
                final int secondIndex = bottomIndex.pop();
                final int orientation = getOrientation(points[bottomIndex.peek()], points[secondIndex], points[i]);
                if (orientation >= 0) {
                    bottomIndex.push(secondIndex);
                    break;
                }
            }
            bottomIndex.push(i);
        }

        // search top
        final Deque<Integer> topIndex = new LinkedList<>();
        for (int i = len - 1; i >=0; --i) {
            while (topIndex.size() >= 2) {
                final int secondIndex = topIndex.pop();
                final int orientation = getOrientation(points[topIndex.peek()], points[secondIndex], points[i]);
                if (orientation >= 0) {
                    topIndex.push(secondIndex);
                    break;
                }
            }
            topIndex.push(i);
        }

        final Set<Integer> fenchIndex = new HashSet<>();
        fenchIndex.addAll(topIndex);
        fenchIndex.addAll(bottomIndex);

        final int[][] outTress = new int[fenchIndex.size()][2];
        int index = 0;
        for (int fench : fenchIndex) {
            outTress[index++] = new int[]{points[fench].x, points[fench].y};
        }

        return outTress;
    }

    @Test
    public void test() {
        final int[][] trees = {{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
        new ErrectTheFence$587().outerTrees(trees);
    }


    @Test
    public void testOritentation() {
        final Point first = new Point(0,0);
        final Point second = new Point(1, 0);
        final Point third = new Point(2, 0);

        System.out.println(new ErrectTheFence$587().getOrientation(first, second, third));
    }
}
