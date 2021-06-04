package com.leetcode.structure.linkedlist;

public class ReverseNodesInKGroups$25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        final ListNode root = new ListNode(0);
        root.next = head;
        ListNode prev = root;
        ListNode curr = root.next;

        int step = 0;
        while (curr != null) {
            curr = curr.next;
            if (++step % k == 0) {
                final ListNode first = prev.next;
                final ListNode firstAfterReverse = reverse(first, curr);
                prev.next = firstAfterReverse;
                prev = first;
                prev.next = curr;
            }
        }
        return root.next;
    }

    private ListNode reverse(ListNode first, ListNode exclusive) {
        ListNode previous = first;
        ListNode curr = first.next;
        while (curr != exclusive) {
            ListNode next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        final ListNode n1 = new ListNode(1);
        final ListNode n2 = new ListNode(2);
        final ListNode n3 = new ListNode(3);
        final ListNode n4 = new ListNode(4);
        final ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        new ReverseNodesInKGroups$25().reverseKGroup(n1, 2);
    }
}
