package com.leetcode.chanllenge.biweek.leetcode53;

public class SubstringOfSizeThreeWithDistinctCharacters {

    public int countGoodSubstring(String s) {
        if (s.length() < 3 ){
            return 0;
        }

        int counter = 0;




        for (int i = 0; i < s.length() - 2; ++i) {
            final char first = s.charAt(i);
            final char second = s.charAt(i + 1);
            final char third = s.charAt(i + 2);

            if (isGoodString(first, second, third)) {
                ++counter;
            }
        }

        return counter;

    }

    private boolean isGoodString(char first, char second, char third) {
        return first != second && second != third && first != third;
    }

}
