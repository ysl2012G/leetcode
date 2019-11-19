package com.leetcode.structure.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum$1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            Integer secondIndex = map.get(target - nums[i]);
            if (secondIndex != null && secondIndex != i) {
                return new int[] {i, secondIndex};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Arrays.stream(new TwoSum$1().twoSum(nums,target)).forEach(System.out::println);
    }
}
