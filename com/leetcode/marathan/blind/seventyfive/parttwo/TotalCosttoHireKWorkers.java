package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.List;
import java.util.PriorityQueue;

public class TotalCosttoHireKWorkers {
    public static void main(String[] args) {
        int [] costs = {17,12,10,2,7,2,11,20,8};
        int k =3;
        int candidates = 4;
        long cost = totalCost(costs, k,candidates);
        System.out.println(cost);
    }

    private static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<Integer> pq1= new PriorityQueue<>();
        PriorityQueue<Integer> pq2= new PriorityQueue<>();
        long ans = 0;

        int hired = 0;
        int i = 0;
        int j = n-1;

        while(hired < k){

            while(pq1.size() < candidates && i<=j)
                pq1.add(costs[i++]);
            while(pq2.size()<candidates && j>=i)
                pq2.add(costs[j--]);


            int a = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int b = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if(a <= b){
                ans += a;
                pq1.poll();
            } else {
                ans += b;
                pq2.poll();
            }

            hired++;
        }

        return ans;
    }
}
