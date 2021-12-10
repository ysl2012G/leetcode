package com.leetcode.structure.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode buildListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        final ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; ++i) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
}

