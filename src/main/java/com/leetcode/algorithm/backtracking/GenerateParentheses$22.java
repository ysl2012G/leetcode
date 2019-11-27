package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses$22 {
    private List<String> res = new ArrayList<>();
	public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(sb, n, n);
        return res;
	}

	private void helper(StringBuilder sb, int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            res.add(sb.toString());
            return;
        }
        if (leftNum != 0 ) {
            sb.append('(');
            helper(sb, leftNum - 1, rightNum);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightNum != 0 && rightNum > leftNum) {
            sb.append(')');
            helper(sb, leftNum, rightNum - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
	}

    public static void main(String[] args) {
        new GenerateParentheses$22().generateParenthesis(3).forEach(System.out::println);
    }
}
