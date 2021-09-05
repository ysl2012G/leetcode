package com.leetcode.structure.segment.tree;

import java.util.*;

public class RectangleAreaII$850 {

    private static class Node {
        private Node left;
        private Node right;


        private int edgeCount = 0;
        private long total = 0;

        private final int start;
        private final int end;
        private final int[] vals;

        Node(int[] vals, int start, int end) {
            this.start = start;
            this.end = end;
            this.vals = vals;
        }
    }

    private Node buildNode(int[] vals, int i, int j) {
        if (i >= j) {
            return null;
        }
        final Node curr = new Node(vals, i, j);
        if (i + 1 == j) {
            return curr;
        }

        final int mid = i + (j - i) / 2;
        curr.left = buildNode(vals, i, mid);
        curr.right = buildNode(vals, mid, j);
        return curr;
    }

    private void update(Node root, int i, int j, int edgeCount) {
        if (i >= root.end || j <= root.start) {
            return;
        }
        if (root.start + 1 == root.end) {
            root.edgeCount += edgeCount;
            root.total = root.edgeCount > 0 ? root.vals[root.end] - root.vals[root.start] : 0;
        } else {
            update(root.left, i, j, edgeCount);
            update(root.right, i, j, edgeCount);
            root.total = root.left.total + root.right.total;
        }
    }

    private static class HorizontalLine {
        private final int y;
        private final int type;
        private final int leftX;
        private final int rightX;

        HorizontalLine(int y, int type, int leftX, int rightX) {
            this.y = y;
            this.type = type;
            this.leftX = leftX;
            this.rightX = rightX;
        }

        public int getY() {
            return y;
        }
    }

    public int rectangleArea(int[][] rectangles) {
        final int OPEN = 1;
        final int CLOSE = -1;

        final int len = rectangles.length;
        final HorizontalLine[] lines = new HorizontalLine[len * 2];

        final Set<Integer> xCoordinates = new TreeSet<>();
        int index = 0;
        for (int[] rectangle : rectangles) {
            lines[index++] = new HorizontalLine(rectangle[1], OPEN, rectangle[0], rectangle[2]);
            lines[index++] = new HorizontalLine(rectangle[3], CLOSE, rectangle[0], rectangle[2]);

            xCoordinates.add(rectangle[0]);
            xCoordinates.add(rectangle[2]);
        }

        Arrays.sort(lines, Comparator.comparingInt(HorizontalLine::getY));
        final int[] vals = xCoordinates.stream().mapToInt(i -> i).toArray();

        final Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < vals.length; ++i) {
            cache.put(vals[i], i);
        }



        final Node root = buildNode(vals, 0, vals.length - 1);
        long ans = 0;
        long currXLen = 0;
        int currY = lines[0].y;

        for (HorizontalLine line : lines) {
            ans += currXLen * (line.y - currY);
            update(root, cache.get(line.leftX), cache.get(line.rightX), line.type);
            currXLen = root.total;
            currY = line.y;
        }

        ans %= 1_000_000_007;
        return (int) ans;
    }

    public static void main(String[] args) {
        final int[][] rectangles = {{0, 0, 2, 2}, { 1, 1, 3, 3}};

        System.out.println(new RectangleAreaII$850().rectangleArea(rectangles));
    }
}
