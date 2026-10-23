package com.com.leetcode.oct;

public class MinimumOperationstoSortaPermutation {
    public static void main(String[] args) {
        int [] nums = {2,0,1};
        int ops = minOperationsII(nums);
        System.out.println(ops);
    }

    private static int minOperationsII(int[] nums) {
        int n = nums.length;
        int asc = 0;
        int desc = 0;
        for(int i=1;i<n;i++){
            //to check asc
            asc += (nums[i]==(nums[i-1]+1)%n)?1:0;
            desc += (nums[i-1] == (nums[i]+1)%n)?1:0;
            if(asc == n-1 && nums[0]==0) return 0;
            if(asc == n-1){
                int leftrotation = n-nums[0];
                int rightRotation = 1+(nums[n-1]+1)+1;
                return Math.min(leftrotation, rightRotation);
            }
            if(desc ==n-1){
                //rev
                int leftRotation = n-nums[n-1]+1;
                //x tie left rot + 1 rev
                int rightRotation = (nums[0]+1)%n +1;

                return Math.min(leftRotation,rightRotation);
            }
        }
        return -1;
    }
}
