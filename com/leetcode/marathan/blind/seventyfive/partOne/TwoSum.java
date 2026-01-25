package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int [] nums = {3,2,4};
        int target = 6;
        int [] res = twoSum(nums, target);
        System.out.println(res[0]+", "+res[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int [] res = new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            int y = target-x;
            if(map.containsKey(y) && i !=map.get(y)){
                res[0] = i;
                res[1] = map.get(y);
                break;
            }
        }
        return res;
    }

}
