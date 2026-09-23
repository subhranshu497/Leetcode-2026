package com.com.leetcode.sept;

public class MinimumOperationstoReduceXtoZero {
    public static void main(String[] args) {
        int [] nums = {1,1};
        int x =3;
        int res = minOperationsI(nums,x);
        System.out.println(res);
    }

    private static int minOperationsI(int[] nums, int x) {
        int n = nums.length;
        //find the total sum
        int sum =0;
        for(int num:nums)
            sum +=num;
        if(sum < x) return -1;
        if(sum==x) return n;
        //now have to find a longest window whose targetSum = sum-x
        int targetSum = sum-x; //20
        int l=0, r = 0;
        int reqSum =0;
        int ans =Integer.MAX_VALUE;

        while(r<n){
            reqSum +=nums[r];
            while(l<n && reqSum>targetSum){
                reqSum -=nums[l];
                l++;
            }
            int subArrLen = r-l+1;
            if(reqSum==targetSum)
                ans = Math.min(ans, n-subArrLen);
            r++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

}
