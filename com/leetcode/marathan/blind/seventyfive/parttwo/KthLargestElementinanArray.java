package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k =2;
        int kth = findKthLargestI(nums, k);
        System.out.println(kth);
    }

    private static int findKthLargestI(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.add(num);
        }
        int count =1;
        while(count != k){
            pq.poll();
            count++;
        }
        return pq.peek();
    }
}
