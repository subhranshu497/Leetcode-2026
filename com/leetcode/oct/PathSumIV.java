package com.com.leetcode.oct;

import java.util.*;

public class PathSumIV {
    public static void main(String[] args) {
        int [] nums = {113,215,221};
        int sum = pathSum(nums);
        System.out.println(sum);
    }

    private static int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int pos = nums[i]/10;
            int val = nums[i]%10;
            map.put(pos, val);
        }
        return calculateSum(map, 1,1,0);
    }

    private static int calculateSum(Map<Integer, Integer> map, int depth, int pos, int sum) {
        int key = depth*10 +pos;
        if(!map.containsKey(key))return -1;
        int val = map.get(key);

        int res = sum+val;
        int left = calculateSum(map, depth+1,(pos-1)*2+1, res);
        int right = calculateSum(map, depth+1, 2*(pos-1)+2,res);
        if(left==-1 && right==-1)return res;
        return Math.max(0, left)+Math.max(0,right);
    }
}
