package com.leetcode.chanllenge.leetcode218;

public class GoalParserInterpretation {
    public String interpret(String command) {
        final StringBuilder builder = new StringBuilder();
        int index = 0;
        int len = command.length();
        while (index < len) {
            final char ch = command.charAt(index);
            if (ch == '(' && index < len - 1) {
                final char nextCh = command.charAt(index + 1);
                if (nextCh == ')') {
                    builder.append('o');
                    index++;
                } else if (nextCh == 'a' && index < len - 3 && "l)".equals(command.substring(index + 2, index + 4))) {
                    builder.append("al");
                    index += 3;
                }  else {
                    builder.append(ch);
                }
            } else {
                builder.append(ch);
            }
            ++index;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        new GoalParserInterpretation().interpret("G()(al)");
    }
}
