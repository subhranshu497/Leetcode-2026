package com.com.leetcode.nov;

public class FindtheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        int [] arr1 = {4,5,8};
        int [] arr2 = {10,9,1,8};
        int d = 2;
        int res = findTheDistanceValue(arr1, arr2, d);
        System.out.println(res);
    }
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int count =0;
        for(int i=0;i<l1;i++){
            int j=0;
            for(;j<l2;j++){
                int diff = Math.abs(arr1[i]-arr2[j]);
                if(diff <=d)break;
            }
            if(j==l2)count++;
        }
        return count;
    }
}
