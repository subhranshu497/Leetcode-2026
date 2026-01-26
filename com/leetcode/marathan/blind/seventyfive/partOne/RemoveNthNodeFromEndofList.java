package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode res = removeNthFromEnd(head, n);
        while(res != null){
            System.out.print(res.val+"-->");
            res = res.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int len = 0;
        while(curr !=null){
            len +=1;
            curr = curr.next;
        }
        if(len==1) return null;
        if(len==n) return head.next;
        int k = len -n;
        int count =0;
        ListNode curr1 = head;
        ListNode res = curr1;
        while(curr1 != null){
            count +=1;
            if(count==k){
                ListNode curr2 = curr1.next;
                curr1.next = curr2.next;
                break;
            }
            curr1 = curr1.next;
        }
        return res;
    }
}
