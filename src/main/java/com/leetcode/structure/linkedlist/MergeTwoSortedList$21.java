package com.leetcode.structure.linkedlist;

public class MergeTwoSortedList$21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        ListNode curr = root;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                break;
            }
            if (l2 == null) {
                curr.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        new MergeTwoSortedList$21().mergeTwoLists(null, new ListNode(0));
    }
}
