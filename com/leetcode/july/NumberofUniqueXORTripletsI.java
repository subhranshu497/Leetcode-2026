package com.com.leetcode.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberofUniqueXORTripletsI {
    public static void main(String[] args) {
        int [] nums = {1,2};
        int res = uniqueXorTriplets(nums);
        System.out.println(res);
    }

//    private static int uniqueXorTriplets(int[] nums) {
//        //remove duplicates
//        int [] arr = Arrays.stream(nums).distinct().toArray();
//        int n = arr.length;
//        Set<Integer> set = new HashSet<>();
//        for(int i=0;i<n;i++){
//            for(int j=i;j<n;j++){
//                int val = arr[i] ^ arr[j];
//                set.add(val);
//            }
//        }
//        Set<Integer> tempSet = new HashSet<>();
//        for(int num:arr){
//            for(int val:set){
//                int res = num ^ val;
//                tempSet.add(res);
//            }
//        }
//        return tempSet.size();
//    }

    private static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <=2)return n;
        return Integer.highestOneBit(n)<<1;
    }
}
