package com.com.leetcode.onefifty;

public class RemoveElement {
    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement(nums, val);
        System.out.println(k);
        //print the arr
        for(int num:nums)
            System.out.print(num +", ");
    }

    private static int removeElement(int[] nums, int val) {
        int k =0;
        int i =0;
        while(i<nums.length){
            if(nums[i] !=val){
                nums[k] = nums[i];
                k++;
            }
            i++;
        }
        return k;
    }
    //one pass


    // two pass
//    private static int removeElement(int[] nums, int val) {
//        int n = nums.length;
//        int k = 0;
//        int i=0;
//        while(i<n){
//            if(nums[i] != val)k++;
//            i++;
//        }
//        //pass 2
//        i =0;
//        int remIdx = k;
//        while(i<k){
//            if(nums[i]==val){
//                while(remIdx<n && nums[remIdx]==val)
//                    remIdx++;
//                nums[i] = nums[remIdx];
//                nums[remIdx] = val;
//                remIdx++;
//            }
//            i++;
//        }
//        return k;
//    }
}
