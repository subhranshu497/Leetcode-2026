package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int [] res = productExceptSelfI(nums);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] productExceptSelfI(int[] nums) {
        int n = nums.length;
        int [] leftToRight = new int[n];
        int [] rightToLeft = new int[n];
        rightToLeft[n-1] =1;
        leftToRight[0] =1;
        //start filling right to left array
        for(int i=n-2;i>=0;i--){
            rightToLeft[i] = rightToLeft[i+1]*nums[i+1];
        }
        for(int i=1;i<n;i++){
            leftToRight[i] = leftToRight[i-1]*nums[i-1];
        }
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=leftToRight[i]*rightToLeft[i];
        }
        return res;
    }
}
