package com.com.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class DistributeElementsIntoTwoArraysI {
    public static void main(String[] args) {
        int [] nums = {5,4,3,8};
        int [] res = resultArray(nums);
        for(int r:res){
            System.out.print(r+", ");
        }
    }

    private static int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);//2,3
        arr2.add(nums[1]);//1
        int i1=0;
        int i2=0;
        for(int i=2;i<n;i++){
            if(arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)){
                arr1.add(nums[i]);
                i1++;
            }else {
                arr2.add(nums[i]);
                i2++;
            }
        }
        //now concat
        int i=0;
        for(i1=0;i1<arr1.size();i1++){
            res[i] =arr1.get(i1);
            i++;
        }
        for(i2=0;i2<arr2.size();i2++){
            res[i] =arr2.get(i2);
            i++;
        }
        return res;
    }
}
