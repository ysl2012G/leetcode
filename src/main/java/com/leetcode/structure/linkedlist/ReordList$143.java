package com.leetcode.structure.linkedlist;

public class ReordList$143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // find middle node
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // reverse the right half
        ListNode prevMiddle = p1;
        ListNode prevCurr = p1.next;
        while (prevCurr.next != null) {
            ListNode curr = prevCurr.next;
            prevCurr.next = curr.next;
            curr.next = prevMiddle.next;
            prevMiddle.next = curr;
        }

        // start reorder one by one
        p1 = head;
        p2 = prevMiddle.next;
        while (p1 != prevMiddle) {
            prevMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = prevMiddle.next;
        }
    }
}
