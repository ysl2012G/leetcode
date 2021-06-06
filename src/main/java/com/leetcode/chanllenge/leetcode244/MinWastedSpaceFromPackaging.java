package com.leetcode.chanllenge.leetcode244;

import java.util.Arrays;

public class MinWastedSpaceFromPackaging {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        final int LEN = packages.length;

        Arrays.sort(packages);
        int packageMaxSize = packages[LEN - 1];
        long sumOfBoxSize = Long.MAX_VALUE;
        for (int[] box : boxes) {

            Arrays.sort(box);

            final int boxMaxSize = box[box.length - 1];
            if (boxMaxSize < packageMaxSize) {
                continue;
            }

            long totalSize = 0;
            int lo = 0;
            for (int size : box) {
                final int hi = binarySearch(packages, lo, size);
                totalSize += (hi - lo) * (long) size;
                lo = hi;
           }
            sumOfBoxSize = Math.min(sumOfBoxSize, totalSize);
        }

        if (sumOfBoxSize == Long.MAX_VALUE) {
            return -1;
        }

        final long MODULE = (long) 1e9 + 7;
        final long sumOfPackages = Arrays.stream(packages).mapToLong(i -> i).sum();

        return (int) ((sumOfBoxSize - sumOfPackages) % MODULE);
    }

    private int binarySearch(int[] packages, int lo, int boxSize) {
        int hi = packages.length;
        while (lo < hi) {
            final int mid = lo + (hi - lo ) / 2;
            if (packages[mid] <= boxSize) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        final int[] packages = {3, 5, 8, 10, 11, 12};
        final int[][] boxes = {{12}, {11, 9}, {10, 5, 14}};
        final int res = new MinWastedSpaceFromPackaging().minWastedSpace(packages, boxes);
        System.out.println(res);
    }
}
