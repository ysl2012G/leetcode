package com.leetcode.chanllenge.leetcode199;

import java.util.Arrays;
import java.util.Comparator;

public class ShuffleString {
    private static class CharInfo {
        char ch;
        int pos;

        CharInfo(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
    public String restoreString(String s, int[] indices) {
        int len = s.length();
        CharInfo[] infos = new CharInfo[len];
        for (int i = 0; i < len; i++) {
            infos[i] = new CharInfo(s.charAt(i), indices[i]);
        }
        Arrays.sort(infos, Comparator.comparingInt(a -> a.pos));
        StringBuilder sb = new StringBuilder();
        for (CharInfo info : infos) {
            sb.append(info.ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ShuffleString().restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}
