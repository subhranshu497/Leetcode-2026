package com.com.leetcode.august;

import java.util.*;

public class MakeLexicographicallySmallestArraybySwappingElements {
    public static void main(String[] args) {
        int [] nums = {1,7,28,19,10};
        int limit = 3;
        int [] res = lexicographicallySmallestArray(nums,limit);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int [] res = new int [n];
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> group = new HashMap<>();
        //form the group
        int [] sortedArr = Arrays.copyOf(nums,n);
        Arrays.sort(sortedArr);
        //to form the group check abs dis
        int grp = 0;
        numToGroup.put(sortedArr[0], grp);
        group.computeIfAbsent(grp, k -> new LinkedList<>()).add(sortedArr[0]);
        for(int i=1;i<n;i++){
            int diff = sortedArr[i]-sortedArr[i-1];
            if(diff > limit)grp++;
            numToGroup.put(sortedArr[i], grp);
            group.computeIfAbsent(grp, k->new LinkedList<>()).add(sortedArr[i]);
        }
        for(int i=0;i<n;i++){
            int groupName = numToGroup.get(nums[i]);
            res[i] = group.get(groupName).pollFirst();
        }
        return res;
    }


//brute force
//    private static int[] lexicographicallySmallestArray(int[] nums, int limit) {
//        int n = nums.length;
//        int [] res = new int[n];
//
//        for(int i=0;i<n;i++){
//            while (true){
//                int idx = -1;
//                int small = nums[i];
//                for(int j=i+1;j<n;j++){
//                    if(nums[j]>nums[i])continue;
//                    int diff = Math.abs(nums[j]-nums[i]);
//                    if(diff <=limit){
//                        if(nums[j]<small){
//                            idx = j;
//                            small = nums[j];
//                        }
//                    }
//                }
//                if(idx !=-1){
//                    int temp = nums[i];
//                    nums[i] = nums[idx];
//                    nums[idx] = temp;
//                }else break;
//            }
//        }
//        return nums;
//    }
}
