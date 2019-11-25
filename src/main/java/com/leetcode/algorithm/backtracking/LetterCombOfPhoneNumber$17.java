package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombOfPhoneNumber$17 {
    private static final Map<Character, String> letterMap = new HashMap<>();
    static {
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
    }

    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }

        StringBuilder sb = new StringBuilder();
        helper(sb, digits, 0);
        return res;
    }

    private void helper(StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = letterMap.get(digit);
        for (char letter: letters.toCharArray()) {
            sb.append(letter);
            helper(sb, digits, index + 1);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        List<String> res = new LetterCombOfPhoneNumber$17().letterCombinations("23");
        res.forEach(System.out::println);
    }
}
