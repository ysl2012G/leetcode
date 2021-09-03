package com.leetcode.algorithm.bit.manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets$90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       final List<List<Integer>> res = new ArrayList<>();

       final int len = nums.length;
       final int subsetSize = (int) Math.pow(2, len);

       for (int i = 0; i < subsetSize; ++i) {
           final List<Integer> subset = new ArrayList<>();
           boolean duplicated = false;
           for (int j = 0; j < len; ++j) {
               if ((i & (1 << j)) > 0) {
                   subset.add(nums[j]);
                   if (j > 0 && nums[j] == nums[j - 1] && (i & (1 << (j - 1))) == 0) {
                       duplicated = true;
                       break;
                   }
               }
           }

           if (!duplicated) {
               res.add(subset);
           }
       }

       return res;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        new Subsets$90().subsetsWithDup(nums);
    }
}
