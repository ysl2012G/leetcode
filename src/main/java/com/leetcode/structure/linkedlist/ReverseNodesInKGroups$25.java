package com.leetcode.structure.linkedlist;

public class ReverseNodesInKGroups$25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        if (k == 1) {
            return head;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode previous = root;
        ListNode curr = root;
        int iteration = 0;
        while (curr.next != null) {
            curr = curr.next;
            if (++iteration % k == 0) {
                previous = reverseNode(previous, curr);
                curr = previous;
            }
        }
        return root.next;
    }

    private ListNode reverseNode(ListNode head, ListNode tail) {
        ListNode next = tail.next;
        tail.next = null;

        ListNode prev = head.next;
        ListNode curr = prev.next;
        ListNode temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode currentTail = head.next;
        currentTail.next = next;
        head.next = tail;
        return currentTail;
    }
}
