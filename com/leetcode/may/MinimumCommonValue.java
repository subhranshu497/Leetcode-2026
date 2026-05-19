package com.com.leetcode.may;

public class MinimumCommonValue {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3};
        int [] nums2 = {2,4};
        int common = getCommon(nums1, nums2);
        System.out.println(common);
    }

    private static int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i1 = 0;
        int i2 = 0;
        while (i1<n1 && i2<n2){
            if(nums1[i1]==nums2[i2]) return nums1[i1];
            else if(nums1[i1]<nums2[i2])
                i1++;
            else i2++;
        }
        return -1;
    }
}
