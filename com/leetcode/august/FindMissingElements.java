package com.com.leetcode.august;

import java.util.*;

public class FindMissingElements {
    public static void main(String[] args) {
        int [] nums ={5,1};
        List<Integer> res = findMissingElements(nums);
        System.out.println(res);
    }

    private static List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if(n==1) return res;
        Arrays.sort(nums);
        Set<Integer> set = new TreeSet<>();
        for(int num:nums)
            set.add(num);
        int min = nums[0];
        int max = nums[n-1];
        int range = max-min+1;
        int diff = range-n;
        //start checking
        int val =min;
        while (diff >0){
            val +=1;
            if(!set.contains(val)){
                res.add(val);
                diff--;
            }
        }

        return res;
    }
}
