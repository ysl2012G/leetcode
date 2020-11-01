package com.leetcode.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesisString$678 {
    public boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> asterisks = new LinkedList<>();
        int strLen = s.length();
        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);
            switch (c) {
            case '(':
                left.push(i);
                break;
            case '*':
                asterisks.push(i);
                break;
            case ')':
                if (left.size() > 0) {
                    left.pop();
                } else if (asterisks.size() > 0) {
                    asterisks.pop();
                } else {
                    return false;
                }
                break;
            default:
                break;
            }
        }
        while (left.size() > 0 && asterisks.size() > 0) {
            if (left.peek() > asterisks.peek()) {
                return false;
            }
            left.pop();
            asterisks.pop();
        }
        return left.isEmpty();
    }

    public static void main(String[] args) {
        String test= "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        new ValidParenthesisString$678().checkValidString(test);
    }
}
