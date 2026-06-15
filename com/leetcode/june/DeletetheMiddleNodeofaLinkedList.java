package com.com.leetcode.june;

import java.util.List;

public class DeletetheMiddleNodeofaLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode res = deleteMiddleI(head);
        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    private static ListNode deleteMiddleI(ListNode head) {
        if(head==null || head.next==null)return null;
        //do it using slow and fast pointer
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode res = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //at this point slow is at the middle of the linked list
        //do the deletion of the middle node
        prev.next = slow.next;
        slow.next = null;
        return res;
    }
}
