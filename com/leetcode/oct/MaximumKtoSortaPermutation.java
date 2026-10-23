package com.com.leetcode.oct;

import java.util.HashSet;
import java.util.Set;

public class MaximumKtoSortaPermutation {
    public static void main(String[] args) {
        int [] nums = {0,3,2,1};
        int ans = sortPermutation(nums);
        System.out.println(ans);
    }

    private static int sortPermutation(int[] nums) {
        int n = nums.length;
        //first find all the misplaced element
        Set<Integer> misplaced = new HashSet<>();
        for(int i=0;i<n;i++){
            if(nums[i] != i)
                misplaced.add(nums[i]);
        }
        //maximum value of k will be the bitwise and of all the num from misplaced set
        int k =-1;//here all bits are set
        for (int num:misplaced){
            k &=num;
        }
        return k==-1?0:k;
    }
}
