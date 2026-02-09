package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode res = oddEvenList(head);
    }

    private static ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        if(head==null || head.next==null) return head;
        ListNode even = head.next;
        ListNode conectingNode = even;
        while (even !=null && even.next !=null){
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next= conectingNode;
        return head;
    }
}
