package com.com.leetcode.onefifty;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement
{
    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
        int element = majorityElement(nums);
        System.out.println(element);
    }

    private static int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num)> n/2) return num;
        }
        return -1;
    }
}
