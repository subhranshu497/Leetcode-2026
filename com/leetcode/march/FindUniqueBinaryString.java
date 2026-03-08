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
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++){
            String s = nums[i];
            if(s.charAt(i) == '0') sb.append('1');
            else sb.append('0');
        }
        return sb.toString();
    }
}
