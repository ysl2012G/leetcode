package com.leetcode.algorithm.dynamic.programming;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump$975 {
    // treeMap
    public int oddEvenJumps(int[] arr) {
        final int len = arr.length;

        int res = 1;
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[len - 1], len - 1);

        final boolean[] higher = new boolean[len];
        higher[len - 1] = true;
        final boolean[] lower = new boolean[len];
        lower[len - 1] = true;

        for (int i = len - 2; i >= 0; --i) {
            final Map.Entry<Integer, Integer> hi = map.ceilingEntry(arr[i]);
            final Map.Entry<Integer, Integer> lo = map.floorEntry(arr[i]);
            if (hi != null) {
                higher[i] = lower[hi.getValue()];
            }
            if (lo != null) {
                lower[i] = higher[lo.getValue()];
            }
            if (higher[i]) { ++res; }
            map.put(arr[i], i);
        }
        return res;
    }
//    单调stack
//    public int oddEvenJumps(int[] arr) {
//        final int len = arr.length;
//        final int[][] pairs = new int[len][2];
//        for (int i = 0; i < len; ++i) {
//            pairs[i] = new int[] {arr[i], i};
//        }
//
//        Arrays.sort(pairs, Comparator.comparingInt((int[] p) -> p[0]).thenComparingInt(p -> p[1]));
//
//        final int[] greater = new int[len];
//        final Deque<Integer> stack = new LinkedList<>();
//        for (int[] pair : pairs) {
//            while (!stack.isEmpty() && stack.peek() < pair[1]) {
//                greater[stack.pop()] = pair[1];
//            }
//            stack.push(pair[1]);
//        }
//
//        Arrays.sort(pairs, Comparator.comparingInt((int[] p) -> -p[0]).thenComparingInt(p -> -p[1]));
//        final int[] smaller = new int[len];
//        stack.clear();
//        for (int[] pair : pairs) {
//            while (!stack.isEmpty() && stack.peek() < pair[1]) {
//                smaller[stack.pop()] = pair[1];
//            }
//            stack.push(pair[1]);
//        }
//
//        final boolean[] odd = new boolean[len];
//        final boolean[] even = new boolean[len];
//        odd[len - 1] = true;
//        even[len - 1] = true;
//        for (int i = len - 2; i >= 0; --i) {
//            odd[i] = even[greater[i]];
//            even[i] = odd[smaller[i]];
//        }
//
//        int res = 0;
//        for (boolean start : odd) {
//            res += start ? 1 : 0;
//        }
//        return res;
//    }
}
