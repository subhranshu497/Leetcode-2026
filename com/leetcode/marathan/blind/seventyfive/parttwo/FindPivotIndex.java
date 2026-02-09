package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class FindPivotIndex {
    public static void main(String[] args) {
        int [] nums = {1,7,3,6,5,6};
        int res = pivotIndex(nums);
        System.out.println(res);
    }

    private static int pivotIndex(int[] nums) {
        int n = nums.length;
        int [] leftToRight = new int[n];
        leftToRight[0] = nums[0];
        int [] rightToLeft = new int[n];
        rightToLeft[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            leftToRight[i]= nums[i]+leftToRight[i-1];
        }
        for(int i=n-2;i>=0;i--){
            rightToLeft[i]= nums[i]+rightToLeft[i+1];
        }
        int idx =-1;
        for(int i=0;i<n;i++){
            if(leftToRight[i]==rightToLeft[i]){
                idx = i;
                break;
            }
        }
        return idx;
    }
}
