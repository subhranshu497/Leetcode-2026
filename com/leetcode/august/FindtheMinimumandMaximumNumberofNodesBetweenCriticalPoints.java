package com.com.leetcode.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);
        int [] res = nodesBetweenCriticalPoints(head);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] nodesBetweenCriticalPoints(ListNode head) {
        int [] res = new int[2];
        Arrays.fill(res, -1);
        //take a list to collect all local minima and local maxima
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        ListNode prev = null;
        int idx =0;
        while (node.next != null){
            if(idx !=0){
                //check for local minima
                if(node.val< prev.val && node.val<node.next.val){
                    list.add(idx);
                }
                else if(node.val > prev.val && node.val>node.next.val){
                    list.add(idx);
                }
            }
            idx++;
            prev = node;
            node = node.next;
        }
        //iterate the list and calculate min and max
        int minD =Integer.MAX_VALUE;
        int maxD = list.size()>1?list.get(list.size()-1)-list.get(0):-1;
        for(int i=1;i<list.size();i++){
            int localD = list.get(i)-list.get(i-1);
            minD = Math.min(minD, localD);
        }
        res[0]=minD==Integer.MAX_VALUE?-1:minD;
        res[1]=maxD;
        return res;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
