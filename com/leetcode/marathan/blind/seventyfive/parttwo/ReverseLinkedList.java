package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseList(head);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head !=null){
            ListNode front = head.next;
            head.next = prev; // at first node , it set to null
            prev = head;
            head = front;
        }
        return prev;
    }
}
class ListNode{
    ListNode next ;
    int val;
    public ListNode(){}
    public ListNode(ListNode next, int val){
        this.next = next;
        this.val = val;
    }
    public ListNode(int val){
        this.val = val;
    }
}
