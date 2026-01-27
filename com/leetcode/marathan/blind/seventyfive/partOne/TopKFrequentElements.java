package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int k = 2;
        int [] res = topKFrequent(nums,k);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        Comparator<int[]> comparator = (int[]a, int[]b)->{
            return Integer.compare(b[1],a[1]);
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            pq.add(new int[]{e.getKey(),e.getValue()});
        }
        int [] res = new int[k];
        int i=0;
        while(k>0){
            int [] curr = pq.poll();
            res[i++]= curr[0];
            k--;
        }
        return res;
    }
}
