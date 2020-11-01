package com.leetcode.chanllenge.leetcode201;

import java.util.Deque;
import java.util.LinkedList;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        int len = s.length();

        Deque<Character> charSeq = new LinkedList<>();
        charSeq.add(s.charAt(0));
        int i = 1;
        while (i < len ) {
            if (charSeq.isEmpty()) {
                charSeq.push(s.charAt(i++));
                continue;
            }

            char first = charSeq.peek();
            char second = s.charAt(i++);
            if (isBad(first, second)) {
                charSeq.pop();
            } else {
                charSeq.push(second);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : charSeq) {
            builder.append(c);
        }
        return builder.reverse().toString();
    }

    private boolean isBad(char first, char second) {
        return (first - 'a' ==  second - 'A') || (first - 'A' == second - 'a') ;
    }

    public static void main(String[] args) {
        new MakeTheStringGreat().makeGood("leEeetcode");
    }
}
