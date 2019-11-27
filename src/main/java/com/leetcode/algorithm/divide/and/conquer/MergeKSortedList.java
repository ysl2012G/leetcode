package com.leetcode.algorithm.divide.and.conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leetcode.structure.linkedlist.ListNode;

public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode root = new ListNode(0);
		if (lists == null || lists.length == 0) {
			return root.next;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		List<ListNode> listNodes = Arrays.asList(lists);
		while (listNodes.size() > 1) {
			int listLen = listNodes.size();
			List<ListNode> mergeNodes = new ArrayList<>();
			int mergeLen = listLen / 2 ;
			for (int i = 0; i < mergeLen; i++) {
				mergeNodes.add(mergeTwoLists(listNodes.get(2 * i), listNodes.get(2 * i + 1)));
			}
			if (mergeLen * 2 < listLen) {
				mergeNodes.add(listNodes.get(listLen - 1));
			}
			listNodes = mergeNodes;
		}
		return listNodes.get(0);
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
