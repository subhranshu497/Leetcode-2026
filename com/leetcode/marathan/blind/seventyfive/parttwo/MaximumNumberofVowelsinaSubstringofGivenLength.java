package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Set;

public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        int res = maxVowels(s,k);
        System.out.println(res);
    }

    private static int maxVowels(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int count =0;
        int maxCount =0;
        Set<Character> vowels = Set.of('a','e','i','o','u');
        while(right<n){
            char lch = s.charAt(left);
            while(right-left+1 <=k){
                char rch = s.charAt(right);
                if(vowels.contains(rch)){
                    count++;
                }
                right++;
            }
            maxCount = Math.max(maxCount, count);
            if(vowels.contains(lch))count--;
            left++;
        }
        return maxCount;
    }
}
