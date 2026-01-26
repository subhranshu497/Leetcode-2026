package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String str = minWindow(s,t);
        System.out.println(str);
    }

    private static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(n>m) return "";
        int i=0;
        int j=0;
        int count =0;
        int minLen=Integer.MAX_VALUE;
        int stIdx =0;
        String res ="";
        // put the char from t to array
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        while(j<m){
            char rch = s.charAt(j);
            if(map.containsKey(rch) && map.get(rch)>0)count++;
            map.put(rch, map.getOrDefault(rch,0)-1);
            j++;
            while (count==n){
                if(j-i < minLen){
                    stIdx =i;
                    minLen = j-i;
                }
                char lch = s.charAt(i);
                map.put(lch, map.getOrDefault(lch,0)+1);
                if(map.get(lch)>0){
                    count--;
                }
                i++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(stIdx, minLen+stIdx);
    }
}
