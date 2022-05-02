package com.leetcode.structure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator$224 {
    public int calculate(String s) {
        final Deque<Integer> deque = new LinkedList<>();
        int result = 0;
        int sign = 1;

        final int len = s.length();

        for (int i = 0; i < len; ++i) {
            final char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int number = ch - '0';

                while (i < len - 1 && Character.isDigit(s.charAt(i + 1))) {
                    number = number * 10 + (s.charAt(i + 1) - '0');
                    ++i;
                }
                result += number * sign;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                deque.push(result);
                deque.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result = result * deque.pop() + deque.pop();
            }
        }

        return result;
    }

    @Test
    public void test() {
        final BasicCalculator$224 solution = new BasicCalculator$224();
        Assertions.assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        Assertions.assertEquals(23, solution.calculate("2147483647"));
    }
}
