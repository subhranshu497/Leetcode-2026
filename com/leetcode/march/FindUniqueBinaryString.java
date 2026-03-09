package com.com.leetcode.march;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        String res = findDifferentBinaryString(nums);
        System.out.println(res);
    }

    private static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for(String num:nums){
            set.add(String.valueOf(Integer.parseInt(num,2)));
        }
        System.out.println(set);
        String res = "";
        for(int num=0;num<=n;num++){
            if(!set.contains(String.valueOf(num))){
                res = Integer.toBinaryString(num);
                while(res.length()<n){
                    res = "0"+res;
                }
                return res;
            }
        }
        return "";
    }
}
