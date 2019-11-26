package com.leetcode.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesis$20 {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int strLen = s.length();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);
            if (isLeftParenthesis(c)) {
                deque.push(c);
            } else if (isRightParenthesis(c)) {
                if (deque.isEmpty() || !isMatched(deque.pop(), c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }

    private boolean isLeftParenthesis(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isRightParenthesis(char c) {
        return c == ')' || c == '}' || c ==']';
    }

    private boolean isMatched(char left, char right) {
        boolean firstCase = left == '(' && right == ')';
        boolean secondCase = left == '{' && right == '}';
        boolean thirdCase = left == '[' && right == ']';
        return firstCase || secondCase || thirdCase;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesis$20().isValid("[{}]{}"));
    }
}
