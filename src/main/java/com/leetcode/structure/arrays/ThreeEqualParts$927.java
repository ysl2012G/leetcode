package com.leetcode.structure.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ThreeEqualParts$927 {
	public int[] threeEqualParts(int[] arr) {
		final int totalOnes = (int) IntStream.of(arr).filter(i -> i > 0).count();

		if (totalOnes % 3 != 0) {
			return new int[]{-1, -1};
		}
		if (totalOnes == 0) {
			return new int[]{0, 2};
		}

		final int partOnes = totalOnes / 3;
		int firstEnd = 0;
		int secondEnd = 0;
		int thirdEnd = 0;

		final int len = arr.length;
		for (int i = 0, count = 0; i < len; ++i) {
			if (arr[i] == 1) {
				++count;
				if (count == partOnes) {
					firstEnd = i;
				} else if (count == partOnes * 2) {
					secondEnd = i;
				} else if (count == totalOnes) {
					thirdEnd = i;
				}
			}
		}

		final int trailingZeros = len - thirdEnd - 1;
		if (trailingZeros > 0 && (!isAllZeros(arr, firstEnd + 1, firstEnd + 1 + trailingZeros)
				|| !isAllZeros(arr, secondEnd + 1, secondEnd + +trailingZeros))) {
			return new int[]{-1, -1};
		}

		firstEnd += trailingZeros;
		secondEnd += trailingZeros;
		thirdEnd = len - 1;

		int firstStart = findFirstOnes(arr, 0, firstEnd + 1);
		int secondStart = findFirstOnes(arr, firstEnd + 1, secondEnd + 1);
		int thirdStart = findFirstOnes(arr, secondStart + 1, secondEnd + 1);

		if (firstEnd - firstStart != secondEnd - secondStart || secondEnd - secondStart != thirdEnd - thirdStart) {
			return new int[]{-1, -1};
		}


		for (int i = 0; i <= firstEnd - firstStart; ++i) {
			final int firstVal = arr[i + firstStart];
			final int secondVal = arr[i + secondStart];
			final int thirdVal = arr[i + thirdStart];

			if (firstVal != secondVal || secondVal != thirdVal) {
				return new int[]{-1, -1};
			}
		}

		return new int[]{firstEnd, secondEnd + 1};
	}

	private boolean isAllZeros(int[] arr, int start, int end) {
		return Arrays.stream(arr, start, end).filter(i -> i > 0).count() == 0;
	}

	private int findFirstOnes(int[] arr, int start, int end) {
		for (int i = start; i < end; ++i) {
			if (arr[i] == 1) {
				return i;
			}
		}
		return -1;
	}

    public static void main(String[] args) {
        final int[] arr = {1,0,1,0,1};
        new ThreeEqualParts$927().threeEqualParts(arr);
    }

}
