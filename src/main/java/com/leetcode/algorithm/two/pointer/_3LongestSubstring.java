package com.leetcode.algorithm.two.pointer;

import java.util.HashSet;
import java.util.Set;

public class _3LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> chars = new HashSet<>();
        int maxSubLen = -1;
        int strLen = s.length();
        int leftPos = 0;
        int rightPos = 0;
        while (rightPos < strLen) {
            char currChar = s.charAt(rightPos);
            if (chars.contains(currChar)) {
				maxSubLen = Math.max(maxSubLen, rightPos - leftPos);
                while (leftPos < rightPos) {
                    char leftChar = s.charAt(leftPos);
                    chars.remove(leftChar);
                    ++leftPos;
                    if (leftChar == currChar) {
                        break;
                    }

                }
            }
            chars.add(currChar);
            ++rightPos;
        }
        maxSubLen = Math.max(maxSubLen, rightPos - leftPos);
        return maxSubLen;
    }


    public static void main(String[] args) {
        System.out.println(new _3LongestSubstring().lengthOfLongestSubstring("pwwkewst"));
    }




}
