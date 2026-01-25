package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class ReverseALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode res = reverseLinkedList(head);

        while (res != null){
            System.out.print(res.val+"-->");
            res = res.next;
        }
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while(head !=null){
            ListNode front = head.next; // store
            head.next = prev; // flip
            prev = head; //move
            head = front; //move
        }
        return prev;
    }
}
class ListNode{
    ListNode next;
    int val;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.next = next;
        this.val = val;
    }
}
