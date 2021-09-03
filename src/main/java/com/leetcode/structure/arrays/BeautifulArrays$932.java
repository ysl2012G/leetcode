package com.leetcode.structure.arrays;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrays$932 {
    public int[] beautifulArray(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(1);

        while (res.size() < n) {
            final List<Integer> tmp = new ArrayList<>();
            for (int i : res) {
                if (i * 2 - 1 <= n) {
                    tmp.add(i * 2 - 1);
                }
            }
            for (int i : res) {
                if (i * 2 <= n) {
                    tmp.add(i * 2);
                }
            }
            res = tmp;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        new BeautifulArrays$932().beautifulArray(5);
    }
}
