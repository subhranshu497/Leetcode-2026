package com.com.leetcode.sept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructUniformParityArrayII {
    public static void main(String[] args) {
        int [] nums1 = {2,3};
        boolean flag = uniformArrayI(nums1);
        System.out.println(flag);
    }

    private static boolean uniformArrayI(int[] nums1) {
        int n = nums1.length;
        List<Integer> nums2 = new ArrayList<>();
        //first check for all even or all odd
        //if even continue else write to the array
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0) {
                int num=nums1[i];
                nums2.add(num);
            }
        }
        if(nums2.size()==n) return true;
        nums2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums1[i]%2 !=0) {
                int num=nums1[i];
                nums2.add(num);
            }
        }
        if(nums2.size()==n) return true;
        nums2 = new ArrayList<>();
        //second condition
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(nums1[i]-nums1[j]>=1){
                    int num=nums1[i]-nums1[j];
                    nums2.add(num);
                    break;
                }
            }
        }
        for(int num:nums2){
            if(num <=0) return false;
        }
        return nums2.size()==n?true:false;
    }
}
