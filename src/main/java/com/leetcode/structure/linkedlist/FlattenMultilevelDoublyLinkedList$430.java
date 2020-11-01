package com.leetcode.structure.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class FlattenMultilevelDoublyLinkedList$430 {
	public static class Node {
		private int val;
		private Node prev;
		private Node next;
		private Node child;

		Node(int val) { this.val = val; }
	}

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		Deque<Node> nextNodes = new LinkedList<>();
		while (curr != null) {
		    Node next = curr.next;
		    Node child = curr.child;
			if (child != null) {
				// unlink next node
                if (next != null) { nextNodes.push(next); }
				// link child node
				curr.next = child;
				child.prev = curr;
				curr.child = null;

				curr = curr.next;
				continue;
			}
			if (next != null || nextNodes.isEmpty()) {
				curr = curr.next;
				continue;
			}
			Node popNode = nextNodes.pop();
			// link next node
			curr.next = popNode;
			popNode.prev = curr;
			curr = curr.next;
		}

		return head;
	}

}
