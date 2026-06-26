package com.com.leetcode.june;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithMajorityElementII {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3};
        int target = 2;
        long res = countMajoritySubarraysII(nums, target);
        System.out.println(res);
    }

    private static long countMajoritySubarraysII(int[] nums, int target) {
        int n = nums.length;
        long res =0;
        Map<Integer, Integer> map = new HashMap<>();
        //create the transformed array
        //if num==target , then 1 else -1
        int [] transformedArr = new int[n];
        for(int i=0;i<n;i++){
            transformedArr[i] = nums[i]==target?1:-1;
        }
        //calculate the cumulative sum
        int [] cumSum = new int[n];
        cumSum[0] = transformedArr[0];
        for(int i=1;i<n;i++){
            cumSum[i] = cumSum[i-1]+transformedArr[i];
        }
        //now check for the valid left point
        // equation is cumsum[i-1] < cumSum[j]
        map.put(0,1);
        long validLeftPoint = cumSum[0]>0?1:0;
        res +=validLeftPoint;
        map.put(cumSum[0], map.getOrDefault(cumSum[0],0)+1);
        for(int i=1;i<n;i++){
            if(nums[i] == target){
                validLeftPoint +=map.getOrDefault(cumSum[i-1],0);
            }else validLeftPoint -=map.getOrDefault(cumSum[i],0);
            res +=validLeftPoint;
            map.put(cumSum[i], map.getOrDefault(cumSum[i],0)+1);
        }
        return res;
    }
}
