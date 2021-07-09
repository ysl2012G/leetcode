package com.leetcode.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentDuplicates$1047 {
    public String removeDuplicates(String s) {
        final Deque<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            final char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        final StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public String removeDuplicatesUseTwoPointers(String s) {
        final int LEN = s.length();
        final char[] res = new char[LEN];
        res[0] = s.charAt(0);
        int prev = 0;

        int curr = 1;
        while (curr < LEN) {
            final char ch = s.charAt(curr);
            if (prev != -1 && res[prev] == ch) {
                --prev;
            } else {
                res[++prev] = ch;
            }

            ++curr;
        }

        return prev != -1 ? new String(res, 0, prev + 1) : "";
    }

    public static void main(String[] args) {
        new RemoveAdjacentDuplicates$1047().removeDuplicates("abbaca");
    }
}
