package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.List;

public class MergekSortedLists {
    public static void main(String[] args) {
        ListNode [] lists = new ListNode[3];
        ListNode res = mergeKLists(lists);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int st=0;
        int end = n-1;
        return breakAndMerge(lists, st, end);
    }

    private static ListNode breakAndMerge(ListNode[] lists, int st, int end) {
        //base case
        if(st==end)return lists[st];
        int mid = st+(end-st)/2;
        ListNode left = breakAndMerge(lists, st, mid);
        ListNode right = breakAndMerge(lists, mid+1,end);

        return mergeTwoLists(left, right);
    }


    //linear traversal
//    private static ListNode mergeKLists(ListNode[] lists) {
//        int k = lists.length;
//        if(k==0) return null;
//        else if(k==1)return lists[0];
//        ListNode res = lists[0];
//        for(int i=1;i<k;i++){
//            res = mergeTwoLists(res,lists[i]);
//        }
//        return res;
//    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //base case
        if(l1==null) return l2;
        if(l2==null) return l1;
        //case -1
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
