package com.com.leetcode.feb;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestBalancedSubstringI {
    public static void main(String[] args) {
        String s = "zzabccy";
        int res = longestBalancedI(s);
        System.out.println(res);
    }

    private static int longestBalancedI(String s) {
        int n = s.length();
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
                if(mapIsBalanced(map)){
                    res = Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }

    private static boolean mapIsBalanced(Map<Character, Integer> map) {
        int firstFreq = -1;
        for(int freq:map.values()){
            if(firstFreq== -1){
                firstFreq = freq;
            }
            else if(firstFreq !=freq)return false;
        }
        return true;
    }
}
