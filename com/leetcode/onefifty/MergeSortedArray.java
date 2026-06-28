package com.com.leetcode.onefifty;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        int n =3;
        int m =3;
        mergeI(nums1, m, nums2,n);
    }

    private static void mergeI(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j =0;
        int k =0;
        int [] arr = new int[m+n];
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                arr[k] = nums1[i];
                i++;
            }else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n){
            arr[k] = nums2[j];
            j++;
            k++;
        }
        k=0;
        for(int num:arr){
            nums1[k++]=num;
        }

    }
}
