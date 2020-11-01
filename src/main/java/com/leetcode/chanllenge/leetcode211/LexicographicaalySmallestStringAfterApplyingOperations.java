package com.leetcode.chanllenge.leetcode211;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LexicographicaalySmallestStringAfterApplyingOperations {
    public String findLexSmallestString(String s, int a, int b) {
        final Set<String> processed = new HashSet<>();
        final Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String smallest = s;
        while (!queue.isEmpty()) {
			final String current = queue.poll();
			final String addStr = applyAddOperation(current, a);
			if (processed.add(addStr)) {
				smallest = addStr.compareTo(smallest) < 0 ? addStr : smallest;
				queue.offer(addStr);
			}
			final String rotateStr = applyRotateOperation(current, b);
			if (processed.add(rotateStr)) {
				smallest = rotateStr.compareTo(smallest) < 0 ? rotateStr : smallest;
				queue.offer(rotateStr);
			}
        }
        return smallest;
    }

    private String applyAddOperation(String s, int a) {
        final char[] chars = s.toCharArray();
        final int len = chars.length;
        for (int i = 1; i < len; i += 2) {
            final int original = chars[i] - '0';
            chars[i] = (char) ((original + a) % 10 + '0');
        }
        return String.valueOf(chars);
    }

    private String applyRotateOperation(String s, int b) {
        final int index = s.length() - b;
        return s.substring(index).concat(s.substring(0, index));
    }

    public static void main(String[] args) {
        System.out.println(new LexicographicaalySmallestStringAfterApplyingOperations().findLexSmallestString("5525", 9, 2));
    }

}
