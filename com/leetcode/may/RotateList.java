package com.com.leetcode.may;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode res = rotateRight(head, k);
        while(res!=null){
            System.out.print(res.val+"-->");
            res = res.next;
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode node = head;
        ListNode oldTail = null;
        int len = 0;
        while(node != null){
            oldTail = node;
            node = node.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode newTail = head;
        int steps = len - k - 1;
        while(steps > 0){
            newTail = newTail.next;
            steps--;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        oldTail.next = head;
        return newHead;
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
