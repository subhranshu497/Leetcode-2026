package com.com.leetcode.may;

public class FixedPoint {
    public static void main(String[] args) {
        int [] arr = {-10,-5,0,3,7};
        int idx = fixedPoint(arr);
        System.out.println(idx);
    }

    private static int fixedPoint(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==i) return i;
        }
        return -1;
    }
}
