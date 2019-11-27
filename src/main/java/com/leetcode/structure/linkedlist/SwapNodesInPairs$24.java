package com.leetcode.structure.linkedlist;

public class SwapNodesInPairs$24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode curr = root;
        ListNode prev = curr;

        while (curr.next != null) {
            curr = curr.next;
            if (curr.next == null) {
                break;
            }
            curr = curr.next;

            // swap node
            ListNode firstNode = prev.next;
            ListNode thirdNode = curr.next;
            prev.next = curr;
            curr.next = firstNode;
            firstNode.next = thirdNode;

            // change position
            curr = firstNode;
            prev = curr;
        }
        return  root.next;
    }
}
