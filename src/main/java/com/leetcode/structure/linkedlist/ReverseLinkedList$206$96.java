package com.leetcode.structure.linkedlist;

public class ReverseLinkedList$206$96 {
    public ListNode reverseList(ListNode head) {
        if (head == null ) {
            return head;
        }
        ListNode curr = head;
        while (head.next != null) {
           ListNode next = head.next;
            ListNode temp =next.next;
            head.next = temp;
            next.next = curr;

            //update
            curr = next;
        }
        return curr;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        int count = 1;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode curr = root;
        while (curr != null && count <= m - 1) {
            curr = curr.next;
            ++count;
        }
        ListNode previousNode = curr;
        curr = curr.next;
        count++;
        ListNode firstNode = curr;
        if (firstNode == null) {
            return root.next;
        }

        while (firstNode.next != null && count <= n) {
            ListNode next = firstNode.next;
            ListNode temp =next.next;
            firstNode.next = temp;
            next.next = curr;

            //update
            curr = next;
            previousNode.next = next;
            count++;
        }

        return root.next;
    }


    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5};
        ListNode head = new ListNode(0);
        ListNode curr = new ListNode(nodes[0]);
        head.next = curr;
        for (int i = 1; i < nodes.length; i++) {
            curr.next = new ListNode(nodes[i]);
            curr = curr.next;
        }

//        new ReverseLinkedList$206$96().reverseList(head.next);
        new ReverseLinkedList$206$96().reverseBetween(head.next, 2, 4);
    }
}
