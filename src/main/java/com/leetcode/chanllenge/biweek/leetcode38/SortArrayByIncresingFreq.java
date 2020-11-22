package com.leetcode.chanllenge.biweek.leetcode38;

import java.util.*;

public class SortArrayByIncresingFreq {
    private static class Node {
        private final int num;
        private int freq;

        Node(int num) {
            this.num = num;
            this.freq = 1;
        }

        void addFreq() {
            ++freq;
        }

        public int getFreq() {
            return freq;
        }

        public int getNum() {
            return num;
        }
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int num : nums) {
            if (nodes.containsKey(num)) {
                nodes.get(num).addFreq();
            } else {
                nodes.put(num, new Node(num));
            }
        }

        final List<Node> values = new ArrayList<>(nodes.values());
        values.sort(Comparator.comparingInt(Node::getFreq).reversed().thenComparingInt(Node::getNum).reversed());

        final int[] result = new int[nums.length];
        int index = 0;
        for (Node node : values) {
            for (int i = 0; i < node.freq; ++i) {
                result[index++] = node.num;
            }
        }
        return result;
    }
}
