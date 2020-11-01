package com.leetcode.structure.linkedlist;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode curr = root.next;
        ListNode prev = root;
        while (curr != null) {
            if (curr.val != val) {
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return root.next;
    }
}
