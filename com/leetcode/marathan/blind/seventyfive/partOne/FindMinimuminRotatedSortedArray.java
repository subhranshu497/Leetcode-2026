package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {3,4,5};
        int num = findMin(nums);
        System.out.println(num);
    }

    private static int findMin(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = n-1;
        while(low<= high){
            int mid = low+(high-low)/2;
            if(nums[mid] > nums[high]){
                low = mid+1;
            }else{
                high = mid-1;
            }
            min = Math.min(min,nums[mid]);
        }
        return min;
    }
}
