package com.leetcode.chanllenge.leetcode265;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.structure.linkedlist.ListNode;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {


        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next != null ?  head.next.next : null;


        final List<Integer> points = new ArrayList<>();
        int index = 2;
        while (third != null) {
            if (second.val < first.val && second.val < third.val) {
                points.add(index);
            }
            if (second.val > first.val && second.val > third.val) {
                points.add(index);
            }

            first = second;
            second = third;
            third = third.next;
            ++index;
        }


        if (points.size() < 2) {
            return new int[]{-1, -1};
        }
        final int[] ans = {Integer.MAX_VALUE, 0};
        final int len = points.size();
        ans[1] = points.get(len - 1) - points.get(0);
        for (int i = 0; i < len - 1; ++i) {
            ans[0] = Math.min(ans[0], points.get(i + 1) - points.get(i));
        }

        return ans;
    }
}
