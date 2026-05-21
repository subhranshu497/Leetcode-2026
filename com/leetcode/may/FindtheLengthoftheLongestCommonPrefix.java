package com.com.leetcode.may;

import java.util.HashSet;
import java.util.Set;

public class FindtheLengthoftheLongestCommonPrefix {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3}, arr2 = {4,4,4};
        int longestPrefix = longestCommonPrefix(arr1, arr2);
        System.out.println(longestPrefix);
    }

    private static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        Set<String> set = new HashSet<>();
        //break the numbers in arr1 into string and ad to set
        for(int i=0;i<n1;i++){
            int num = arr1[i];
            while(num>0){
                set.add(String.valueOf(num));
                num = num/10;
            }
        }
        //now iterate the arr2 and check the longest prefix
        int prefix = 0;
        for(int i=0;i<arr2.length;i++){
            int num = arr2[i];
            String str = String.valueOf(num);
            for(int j=0;j<str.length();j++){
                String prefixStr = str.substring(0,j+1);
                if(set.contains(prefixStr)){
                    prefix = Math.max(prefix, prefixStr.length());
                }
            }
        }
        return prefix;
    }

//    private static int longestCommonPrefix(int[] arr1, int[] arr2) {
//        int n1 = arr1.length;
//        int n2 = arr2.length;
//        int prefix = 0;
//        for(int i=0;i<n1;i++){
//            int prefix_temp =0;
//            for(int j=0;j<n2;j++){
//                String s1 = String.valueOf(arr1[i]);
//                String s2 = String.valueOf(arr2[j]);
//                prefix_temp = getPrefixI(s1, s2);
//                prefix = Math.max(prefix, prefix_temp);
//            }
//        }
//        return prefix;
//    }
//
//    private static int getPrefixI(String s1, String s2) {
//        int n1 = s1.length();
//        int n2 = s2.length();
//        int prefix = 0;
//        for(int i=0;i<n1 && i<n2;i++){
//            if(s1.charAt(i) !=s2.charAt(i)) break;
//            prefix++;
//        }
//        return prefix;
//    }
}
