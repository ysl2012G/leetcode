package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ExpressionAddOperations$282 {
    private Set<String> expressions;
    private String num;
    private long target;
    private int len;

    public List<String> addOperators(String num, int target) {
        this.expressions = new HashSet<>();
        this.num = num;
        this.target = target;
        this.len = num.length();

        final StringBuilder prevExpression = new StringBuilder();
        helper(prevExpression, 0, 0, 0, true);

        return new ArrayList<>(expressions);
    }

    private void helper(StringBuilder prevExpression, int startIndex, long prevRes, long prevNumber, boolean isAddOperand) {
        if (startIndex >= len) {
            final long res = isAddOperand ? prevRes + prevNumber : prevRes - prevNumber;
            if (res == target) {
                expressions.add(prevExpression.toString());
            }
            return;
        }
        final int currentLength = prevExpression.length();
        for (int endIndex = startIndex + 1; endIndex <= len; ++endIndex) {
            final long number = Long.parseLong(num.substring(startIndex, endIndex));

            if (Long.toString(number).length() != endIndex - startIndex) {
                continue;
            }

            // with add operand
            final long currRes = isAddOperand ? prevRes + prevNumber : prevRes - prevNumber;

            if (currentLength != 0) { prevExpression.append('+'); }
            prevExpression.append(number);
            helper(prevExpression, endIndex, currRes, number, true);
            prevExpression.delete(currentLength, prevExpression.length());

            // with minus operand
            if (currentLength == 0) { continue; }
            prevExpression.append('-').append(number);
            helper(prevExpression, endIndex, currRes, number, false);
            prevExpression.delete(currentLength, prevExpression.length());

            // with multiply operand
            if (currentLength == 0) { continue; }
            prevExpression.append('*').append(number);
            helper(prevExpression, endIndex, prevRes, prevNumber * number, isAddOperand);
            prevExpression.delete(currentLength, prevExpression.length());
        }
    }


    @Test
    public void test() {
        final ExpressionAddOperations$282 solution = new ExpressionAddOperations$282();
        solution.addOperators("00", 0);
    }

}
