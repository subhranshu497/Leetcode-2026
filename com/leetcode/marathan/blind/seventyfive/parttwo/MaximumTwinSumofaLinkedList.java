package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaximumTwinSumofaLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        int sum = pairSum(head);
        System.out.println(sum);
    }

    private static int pairSum(ListNode head) {
        //step 1 - find the middle of the ll using slow and fast
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //step-2 slow reaches the mid of the list, so this is the point where we need to reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow;
        while(curr !=null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr =front;
        }
        //step - 3 run through these two list
        int max = Integer.MIN_VALUE;
        while(head !=null && prev !=null){
            int sum = head.val+ prev.val;
            max = Math.max(sum ,max);
            prev = prev.next;
            head = head.next;
        }
        return max;
    }
}
