package com.leetcode.structure.linkedlist;

public class SplitLinkedListInParts$725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int sum = 0;
        ListNode curr = head;
        while (curr != null) {
            ++sum;
            curr = curr.next;
        }

        final int equalParts = sum / k;
        final int remainParts = sum % k;

        final ListNode[] ans = new ListNode[k];

        for (int i = 0; i < k; ++i) {
            int step = equalParts + (i < remainParts ? 1 : 0);
            ans[i] = head;
            ListNode prev = head;
            while (step-- > 0) {
                prev = head;
                head = head.next;
            }
            if (prev != null) {
                prev.next = null;
            } else {
                break;
            }
        }

        return ans;
    }
}
