package com.com.leetcode.onefifty;

public class RotateArray {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotateIII(nums,k);
    }

    private static void rotateIII(int[] nums, int k) {
        int n = nums.length;
        //reverse the whole array
        reverseArray(0,n-1,nums);
        //now resverse 0 to k-1
        reverseArray(0,k-1,nums);
        //now reverse k to n-1
        reverseArray(k,n-1,nums);
    }

    private static void reverseArray(int st, int end, int[] nums) {
        while(st<end){
            int temp = nums[st];
            nums[st]= nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }


//    private static void rotateIII(int[] nums, int k) {
//        int n = nums.length;
//        int [] temp = new int[n];
//        for(int i=n-1;i>=0;i--){
//            int tempIdx = i+k;
//            int mod = tempIdx%n;
//            temp[mod] = nums[i];
//        }
//        for(int i=0;i<n;i++){
//            nums[i] = temp[i];
//        }
//    }
}
