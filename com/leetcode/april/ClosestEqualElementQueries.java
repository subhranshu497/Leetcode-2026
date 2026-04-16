package com.com.leetcode.april;

import java.util.*;

public class ClosestEqualElementQueries {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int [] queries = {0,1,2,3};
        List<Integer> res = solveQueries(nums,queries);
        System.out.println(res); // Output the result
    }

    private static List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        List<Integer> res = new ArrayList<>();
        for(int q : queries) {
            int num = nums[q];
            List<Integer> indices = map.get(num);
            int minDist = Integer.MAX_VALUE;
            if(indices.size()==1)
            {
                res.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(indices, q);
            int right = indices.get((pos+1)%indices.size());
            int dist = Math.abs(q - right);
            int circularDist = n-dist;
            minDist = Math.min(minDist, Math.min(dist, circularDist));
            int left = indices.get((pos-1+indices.size())%indices.size());
            dist = Math.abs(q - left);
            circularDist = n-dist;
            minDist = Math.min(minDist, Math.min(dist, circularDist));

            res.add(minDist==Integer.MAX_VALUE?-1:minDist);
        }
        return res;
    }
}
