package com.leetcode.structure.string;

public class LongestCommonPrefix$14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        String firstStr = strs[0];
        int strLen = firstStr.length();
        int strArrayLen = strs.length;
        for (int i = 0; i < strLen; i++) {
            char c = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {

                if (strs[j].length() < i + 1 || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
}
            sb.append(c);
                    }
        return sb.toString();
    }
}
