package com.com.leetcode.sept;

public class SmallestStableIndexI {
    public static void main(String[] args) {
        int [] nums = {0};
        int k =0;
        int res = firstStableIndex(nums,k);
        System.out.println(res);
    }

    private static int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int score = Integer.MAX_VALUE;
        //first calculte max and min arr
        int [] maxArr = new int[n];
        int [] minArr = new int[n];
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
            maxArr[i] = max;
        }
        for(int i=n-1;i>=0;i--){
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }
        for(int i=0;i<n;i++){
            int diff = maxArr[i]-minArr[i];
            if(diff <=k) return i;
        }
        return score==Integer.MAX_VALUE?-1:score;
    }
}
