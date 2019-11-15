package com.leetcode.structure.linkedlist;

public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode result = root;
        int val = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            val = (l1.val + l2.val + carry) % 10 ;
            carry =(l1.val + l2.val + carry) / 10;
            result.next = new ListNode(val);

            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return root.next;
    }
}
