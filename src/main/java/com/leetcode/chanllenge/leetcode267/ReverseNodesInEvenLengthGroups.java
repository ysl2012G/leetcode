package com.leetcode.chanllenge.leetcode267;

import org.junit.jupiter.api.Test;

import com.leetcode.structure.linkedlist.ListNode;

public class ReverseNodesInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = 1;
        int currLen = 1;
        ListNode curr = head;

        ListNode previousEnd = head;
        while (curr.next != null) {
            final ListNode next = curr.next;
            if (currLen == len) {
                if (len % 2 == 0) {
                    curr.next = null;
                    final ListNode first = previousEnd.next;
                    reverseNode(first);
                    previousEnd.next = curr;
                    curr = first;
                    curr.next = next;
                }
                currLen = 0;
                previousEnd = curr;
                ++len;
            }
            ++currLen;
            curr = next;
        }
        if (currLen > 0 && currLen % 2 == 0) {
            final ListNode first = previousEnd.next;
            reverseNode(first);
            previousEnd.next = curr;
        }


        return head;
    }

    private void reverseNode(ListNode curr) {
        ListNode prev = curr;
        while (curr.next != null) {
            final ListNode next = curr.next;
            final ListNode temp = next.next;
            next.next = prev;
            prev = next;
            curr.next = temp;
        }
    }

    @Test
    public void test() {
        final ReverseNodesInEvenLengthGroups solution = new ReverseNodesInEvenLengthGroups();
        final ListNode head = ListNode.buildListNode(new int[] {0, 4, 2, 1, 3});
//        final ListNode head = ListNode.buildListNode(new int[] {5,2,6,3,9,1,7,3,8,4});
        solution.reverseEvenLengthGroups(head);
    }


}
