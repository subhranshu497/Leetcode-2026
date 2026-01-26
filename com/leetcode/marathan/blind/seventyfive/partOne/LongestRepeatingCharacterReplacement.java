package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k =1;
        int res = characterReplacement(s,k);
        System.out.println(res);
    }

    private static int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int windowSize =0;
        int maxFreq = 0;
        int res = 0;
        while (j<n){
            char rch = s.charAt(j);
            char lch = s.charAt(i);
            windowSize = j-i+1;
            map.put(rch, map.getOrDefault(rch,0)+1);
            maxFreq = Math.max(maxFreq, map.getOrDefault(rch,0));
            int char_to_be_changed = windowSize-maxFreq;
            if(char_to_be_changed >k){
                map.put(lch, map.getOrDefault(lch,0)-1);
                i++;
            }
            res = Math.max(res, j-i+1);
            j++;
        }
        return res;
    }
}
