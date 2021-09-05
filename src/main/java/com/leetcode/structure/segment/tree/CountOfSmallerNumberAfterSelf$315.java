package com.leetcode.structure.segment.tree;

import java.util.*;
import java.util.stream.Collectors;

public class CountOfSmallerNumberAfterSelf$315 {
    private static class SegmentTree {
        private final int[] counter;

        SegmentTree(int len) {

            int leaves = 1;
            while (leaves < len) { leaves <<= 1; }
            counter = new int[2 * leaves - 1];
            Arrays.fill(counter, 0);
        }

        void update(int treeIndex, int start, int end, int updatedIndex) {
            if (updatedIndex > end || updatedIndex < start) {
                return;
            }
            if (start == end) {
                counter[treeIndex] += 1;
                return;
            }
            final int mid = start + (end - start) / 2;
            final int leftNodeIndex = 2 * treeIndex + 1;
            final int rightNodeIndex = 2 * treeIndex + 2;
            update(leftNodeIndex,  start, mid, updatedIndex);
            update(rightNodeIndex, mid + 1, end, updatedIndex);
            counter[treeIndex] = counter[leftNodeIndex] + counter[rightNodeIndex];
        }

        int query(int treeIndex, int start, int end, int queryStart, int queryEnd) {
            if (queryEnd < start || queryStart > end) {
                return 0;
            }
            if (queryStart <= start && queryEnd >= end) {
                return counter[treeIndex];
            }
            final int mid = start + (end - start) / 2;
            return query(2 * treeIndex + 1, start, mid, queryStart, queryEnd) + query(2 * treeIndex + 2, mid + 1, end, queryStart, queryEnd);
        }
    }



    public List<Integer> countSmaller(int[] nums) {
        final Set<Integer> vals = new TreeSet<>();
        for (int num : nums) {
            vals.add(num);
        }
        final Map<Integer, Integer> cache = new HashMap<>();

        int index = 0;
        for (int val : vals) {
            cache.put(val, index++);
        }

        final SegmentTree segmentTree = new SegmentTree(vals.size());


        final int numsLen = nums.length;
        final int valsLen = vals.size();
        final int[] res = new int[numsLen];
        for (int i = numsLen - 1; i >= 0; --i) {
            final int updatedIndex = cache.get(nums[i]);
            res[i] = segmentTree.query(0, 0, valsLen - 1, 0, updatedIndex - 1);
            segmentTree.update(0, 0, valsLen - 1, updatedIndex);
        }

        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        final int[] nums = {-1, -1};
        System.out.println(new CountOfSmallerNumberAfterSelf$315().countSmaller(nums));
    }
}
