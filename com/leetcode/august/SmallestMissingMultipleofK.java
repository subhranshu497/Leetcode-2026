package com.com.leetcode.august;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingMultipleofK {
    public static void main(String[] args) {
        int [] nums = {8,2,3,4,6};
        int k = 2;
        int res = missingMultiple(nums,k);
        System.out.println(res);
    }

    private static int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        //brute force
        int step =k;
        while(true){
            if(set.contains(k)){
                k +=step;
            }else{
                return k;
            }
        }
    }
}
