package com.com.leetcode.august;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences {
    public static void main(String[] args) {
        String s = "bcbbbcba";
        int res = maximumLengthSubstring(s);
        System.out.println(res);
    }

    private static int maximumLengthSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l =0;
        int r = 0;
        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            while(map.get(s.charAt(r)) >2){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}
