package com.leetcode.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicCalculatorII$207 {
    public int calculate(String s) {
        final Deque<Integer> stack = new LinkedList<>();
        final int len = s.length();
        int digit = 0;
        char operator = '+';
        for (int i = 0; i < len; ++i) {
            final char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                digit = digit * 10 + (ch - '0');
            }

            final boolean isDigitOrWhiteSpace = Character.isDigit(ch) || Character.isWhitespace(ch);
            if (i != len - 1 && isDigitOrWhiteSpace) {
                continue;
            }

            if (operator == '+') {
                stack.push(digit);
            } else if (operator == '-') {
                stack.push(-digit);
            } else if (operator == '*') {
                stack.push(stack.pop() * digit);
            } else if (operator == '/') {
                stack.push(stack.pop() / digit);
            }
            digit = 0;
            operator = ch;
        }

        return (int) stack.stream().count();
    }

    @Test
    public void test() {
        final BasicCalculatorII$207 solution = new BasicCalculatorII$207();
        Assertions.assertEquals(7, solution.calculate("3 + 2 * 2"));

    }
}
