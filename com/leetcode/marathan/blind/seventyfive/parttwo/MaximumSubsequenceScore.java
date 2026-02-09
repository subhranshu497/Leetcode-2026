package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    //private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        int [] nums1 = {1,3,3,2};
        int [] nums2 = {2,1,3,4};
        int k =3;
        long res = maxScore(nums1, nums2,k);
        System.out.println(res);
    }

    private static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int [][] num = new int[n][2];
        for(int i=0;i<n;i++){
            num[i][0] = nums1[i];
            num[i][1] = nums2[i];
        }
        Arrays.sort(num, Comparator.comparingInt((int [] a)->a[1]).reversed());
        int i=0;
        long sum = 0;
        int min =0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int [] arr:num){
            if(i==k)break;
            sum +=arr[0];
            minHeap.add(arr[0]);
            min = arr[1];
            i++;
        }
        long res = sum*min;
        for(int j=k;j<n;j++){
            int first = num[j][0];
            int second = num[j][1];
            int currminFromfirst = minHeap.poll();
            minHeap.add(first);
            sum -=currminFromfirst;
            sum +=first;

            res = Math.max(res, sum*second);
        }
        return res;
    }

    //brute force
//    private static long maxScore(int[] nums1, int[] nums2, int k) {
//        int n = nums1.length;
//        return maxScoreSolve(nums1,nums2,n,k,0,0,0,0);
//    }
//
//    private static long maxScoreSolve(int[] nums1, int[] nums2, int n, int k, int i, long sum, int min, int count) {
//        //base case
//        if(count==k){
//            return (long) (sum*min);
//        }
//        if(i>=n)return 0;
//        //in case of take
//        pq.add(nums2[i]);
//        long take = maxScoreSolve(nums1, nums2,n,k,i+1,sum+nums1[i],pq.peek(), count+1);
//        pq.remove(nums2[i]);
//        long skip = maxScoreSolve(nums1, nums2, n,k,i+1,sum, min,count);
//        return Math.max(take, skip);
//    }
}
