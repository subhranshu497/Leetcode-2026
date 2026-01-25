package com.com.leetcode.marathan.blind.seventyfive.partOne;

import javax.swing.*;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int [] nums = {0,0,0,0};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int x = nums[i];
            int x_ = -x;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int y = nums[j];
                int z = nums[k];
                if(y+z == x_){
                    List<Integer> list  = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    list.add(z);
                    set.add(list);
                    j++;
                    k--;
                }else if(y+z > x_) k--;
                else j++;
            }
        }
        return new ArrayList<>(set);
    }
}
