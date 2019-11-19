package com.leetcode.algorithm.two.pointer;

public class ContainerWithMostWater$11 {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while (left != right) {
			int currentArea = 0;
			if (height[left] < height[right]) {
				currentArea = height[left] * (right - left);
				left++;
			} else {
				currentArea = height[right] * (right - left);
				right--;
			}
			maxArea = Math.max(maxArea, currentArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println(new ContainerWithMostWater$11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
	}

}
