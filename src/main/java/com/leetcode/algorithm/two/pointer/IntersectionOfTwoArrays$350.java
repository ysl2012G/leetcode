package com.leetcode.algorithm.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays$350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i1 = 0;
        final int len1 = nums1.length;

        int i2 = 0;
        final int len2 = nums2.length;


        final List<Integer> res = new ArrayList<>();
        while (i1 < len1 && i2 < len2) {
            if (nums1[i1] == nums2[i2]) {
                res.add(nums1[i1]);
                ++i1;
                ++i2;
            } else if (nums1[i1] < nums2[i2]) {
                ++i1;
            } else {
                ++i2;
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
