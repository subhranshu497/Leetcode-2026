package com.com.leetcode.june;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumofaLinkedList    {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        int res = pairSumI(head);
        System.out.println(res);
    }

    //approach 2- using two pointer approach
    private static int pairSumI(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //Step 1 - find the middle of the linked list using slow and fast pointer approach
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //at this point slow is at the middle of the linked list
        //Step 2 - reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        //step 3 - now calculate the twin sum and find the maximum twin sum
        int maxSum = Integer.MIN_VALUE;
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        while (secondHalf != null) {
            int sum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, sum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
    }

//    private static int pairSumI(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        ListNode temp = head;
//        while(temp!=null){
//            list.add(temp.val);
//            temp = temp.next;
//        }
//        int maxSum = Integer.MIN_VALUE;
//        int n = list.size();
//        for(int i=0;i<n/2;i++){
//            int sum = list.get(i) + list.get(n-1-i);
//            maxSum = Math.max(maxSum, sum);
//        }
//        return maxSum;
//    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
