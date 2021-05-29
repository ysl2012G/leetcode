package com.leetcode.chanllenge.biweek.leetcode48;

public class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;

        for (int i = 0; i < s.length(); ++i) {
            final char ch = s.charAt(i);
            if (Character.isDigit(s.charAt(i))) {
                final int current = ch - '0';

                if (current > second && current != first) {
                    final int larger = Math.max(first, current);
                    final int smaller = Math.min(first, current);

                    first = larger;
                    second = smaller;
                }
            }
        }

        return second;
    }


    public static void main(String[] args) {
        new SecondLargestDigitInAString().secondHighest("dfa12321afd");
    }
}
