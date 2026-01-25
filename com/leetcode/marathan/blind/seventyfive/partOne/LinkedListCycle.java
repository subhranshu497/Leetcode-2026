package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class LinkedListCycle
{
   private boolean detectCycleInLinkedList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
