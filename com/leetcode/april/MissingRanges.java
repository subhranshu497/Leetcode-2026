package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] nums = {-1};
        int lower = -1;
        int upper = -1;
        List<List<Integer>> res = findMissingRanges(nums, lower, upper);
        System.out.println(res);
    }

    private static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> missingRanges = new ArrayList<>();
        for(int i=0;i<n;i++){
            int prev = nums[i];
            if(lower==prev){
                continue;
            }else if(i>0 && nums[i-1]+1==nums[i]) continue;
            else if(i < n){
                int l_bound = nums[i-1]+1;
                int u_bound = nums[i]-1;
                missingRanges.add(List.of(l_bound, u_bound));
            }else{
                int l_bound = nums[i-1]+1;
                int u_bound = upper;
                missingRanges.add(List.of(l_bound, u_bound));
            }
        }
        if(nums[n-1]<upper){
            missingRanges.add(List.of(nums[n-1]+1, upper));
        }
        return missingRanges;
    }
}
