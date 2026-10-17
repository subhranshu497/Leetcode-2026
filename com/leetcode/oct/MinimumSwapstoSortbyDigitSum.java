package com.com.leetcode.oct;

import java.util.*;

public class MinimumSwapstoSortbyDigitSum {
    public static void main(String[] args) {
        int [] nums = {37,100};
        int swap = minSwapsI(nums);
        System.out.println(swap);
    }

    private static int minSwapsI(int[] nums) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int n = nums.length;
        int [] numArr = new int[n];
        //step 1 - calculate the digit sum and store in map
        int i=0;
        for(int num:nums){
            int sum =0;
            int temp = num;
            while(temp>0){
                int rem = temp%10;
                sum +=rem;
                temp /=10;
            }
            map.computeIfAbsent(sum, k->new ArrayList<>()).add(num);
            //numArr[i]=sum;
        }
        int swap =0;
        int seq =0;
        Comparator<int[]> com = Comparator.comparingInt((int[]a)->a[0])
                .thenComparingInt(a->a[1]);
        PriorityQueue<int[]>pq = new PriorityQueue<>(com);
        //fill the pq
        for(Map.Entry<Integer,List<Integer>> e:map.entrySet()){
            int key =e.getKey();
            List<Integer> val = e.getValue();
            for(int v:val){
                pq.offer(new int[]{key,v});
            }
        }
        //poll from the pq and keep counting
        int[] sortedNums = new int[n];
        i = 0;
        while (!pq.isEmpty()){
            sortedNums[i++] = pq.poll()[1];
        }
        // Map each sorted value to its target index
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int j = 0; j < n; j++) {
            valueToIndex.put(sortedNums[j], j);
        }
// Count cycles to find minimum swaps
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int j = 0; j < n; j++) {
            if (visited[j] || valueToIndex.get(nums[j]) == j) {
                continue;
            }
            int curr = j;
            int cycleSize = 0;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = valueToIndex.get(nums[curr]);
                cycleSize++;
            }
            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }
        return swaps;
    }
}
