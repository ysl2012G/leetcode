package com.leetcode.structure.linkedlist;

public class RemoveNthNodeFromEndList$19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode leftNode = root;
        ListNode rightNode = root;
        for(int i = 0; i < n ; i++) {
            rightNode = rightNode.next;
            if (rightNode == null) {
                return root.next;
            }
        }

        while (rightNode.next != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        ListNode removedNode = leftNode.next;
        leftNode.next = removedNode.next;
        return root.next;
    }
}
