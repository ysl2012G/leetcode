package com.leetcode.algorithm.two.pointer;

public class TradingRainWater$42 {
    public int trap(int[] height) {
        final int len = height.length;

        int left = 0;
        int right = len - 1;
        int leftMax = 0;
        int rightMax = 0;

        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                ++left;
             } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                --right;
            }
        }

        return ans;



        // stack
//        final Deque<Integer> stack = new LinkedList<>();
//        int i = 0;
//
//        int ans = 0;
//        while (i < len) {
//            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
//                stack.push(i ++);
//            } else {
//                final int top = stack.pop();
//                if (stack.isEmpty()) {
//                    continue;
//                }
//                final int width = i - stack.peek() - 1;
//                ans += (Math.min(height[i], height[stack.peek()]) - height[top]) * width;
//            }
//        }
//        return ans;
    }

    public static void main(String[] args) {
        final int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        new TradingRainWater$42().trap(nums);
    }



}
