package com.leetcode.algorithm.dynamic.programming;

public class LongestPalindromicSubstring$5 {
	public String longestPalindrome(String s) {
	    return manacher(s);
//		return dynamicProgramming(s);
	}

	private String dynamicProgramming(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		int strLen = s.length();
		String parStr = "";
		boolean[][] demo = new boolean[strLen][strLen];
		parStr = s.substring(0, 1);
		for (int i = 0; i < strLen; i++) {
			demo[i][i] = true;
			if (i + 1 < strLen && s.charAt(i) == s.charAt(i + 1)) {
				demo[i][i + 1] = true;
				if (parStr.length() < 2) {
					parStr = s.substring(i, i + 2);
				}
			}
		}

		for (int subLen = 3; subLen <= strLen; subLen++) {
			for (int startPos = 0; startPos <= strLen - subLen; startPos++) {
				int endPos = startPos + subLen - 1;
				demo[startPos][endPos] = demo[startPos + 1][endPos - 1] && s.charAt(startPos) == s.charAt(endPos);
				if (demo[startPos][endPos] && parStr.length() < subLen) {
					parStr = s.substring(startPos, endPos + 1);
				}
			}
		}
		return parStr;
	}

	private String manacher(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		String str = preprocess(s);
		int strLen = str.length();
        int[] parLen = new int[strLen];
        int centPos = 0;
        int rightBoundary = 0;
        String parStr = "";
        for (int i = 1; i < strLen - 1; i++) {
            int mirrorPos = 2 * centPos - i;

            if (i < rightBoundary) {
                  parLen[i] = Math.min(rightBoundary - i, parLen[mirrorPos]);
            }

            int expandLeft = i - (parLen[i] + 1);
            int expandRight = i + (parLen[i] + 1);
            while (expandLeft >=0 && expandRight < strLen && str.charAt(expandLeft) == str.charAt(expandRight)) {
                parLen[i]++;
                expandLeft--;
                expandRight++;
            }

            if (parLen[i] + i > rightBoundary) {
                centPos = i ;
                rightBoundary = i + parLen[i];
                if (parLen[centPos] > parStr.length()) {
                    int leftPos = (centPos - parLen[centPos]) >> 1;
                    int rightPos = (centPos + parLen[centPos]) >> 1;
                    parStr = s.substring(leftPos, rightPos);
                }
            }
        }
        return parStr;
	}

	private String preprocess(String s) {
		int strLen = s.length();
		StringBuilder sb = new StringBuilder();
		sb.append('#');
		for (int i = 0; i < strLen; i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
		return sb.toString();
	}


	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring$5().longestPalindrome("abaa"));
	}

}
