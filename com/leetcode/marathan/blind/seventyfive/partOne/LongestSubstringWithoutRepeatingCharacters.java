package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);
    }

    private static int lengthOfLongestSubstring(String s) {
        if(s.length()==1) return 1;
        Set<Character> set = new HashSet<>();
        int i =0;
        int j = 1;
        int n = s.length();
        int maxLen = 0;
        set.add(s.charAt(0));
        while (j<n){
            char lch = s.charAt(i);
            char rch = s.charAt(j);
            while (j<n && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            maxLen = Math.max(maxLen, j-i);
            set.remove(lch);
            i++;
        }
        return maxLen;
    }
}
