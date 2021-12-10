package com.leetcode.structure.linkedlist;

import org.junit.jupiter.api.Test;

public class OddEvenList$328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        if (odd == null) {
            return null;
        }
        ListNode even = head.next;
        if (even == null) {
            return head;
        }
        final ListNode evenStart = even;
        boolean isEven = false;
        ListNode curr = even.next;
        while (curr != null) {
            if (isEven) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            isEven = !isEven;
            curr = curr.next;
        }

        odd.next = evenStart;
        even.next = null;
        return head;
    }

    @Test
    public void test() {
        final ListNode head  = ListNode.buildListNode(new int[] {1, 2, 3, 4, 5});
        final OddEvenList$328 solution = new OddEvenList$328();
        solution.oddEvenList(head);
    }
}
