package com.com.leetcode.june;

import java.util.*;

public class FindtheMaximumNumberofElementsinSubset
{
    public static void main(String[] args) {
        int [] nums = {5,4,1,2,2};
        int res = maximumLength(nums);
        System.out.println(res);
    }

    private static int maximumLength(int[] nums) {
        int n = nums.length;
        Map<Long, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        //special case 1
        int countOnes =0;
        for(int num:nums){
            if(num==1){
                countOnes++;
                continue;
            }
            map.put((long)num, map.getOrDefault((long)num,0)+1);
        }
        if(countOnes %2 ==0)countOnes -=1;
        maxLen = countOnes;
        //iterate the map
        for(Map.Entry<Long, Integer> e:map.entrySet()){
            int len =0;
            int exp =2;
            long num = e.getKey();
            while(map.get(num)>1){
                len +=2;
                num *=num;
                if(num >1000000000)break;
            }
            if(map.getOrDefault(num,0)==1) len +=1;
            else len -=1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
