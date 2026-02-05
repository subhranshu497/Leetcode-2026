package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Set;

public class ReverseVowelsofaString {
    public static void main(String[] args) {
        String s = "IceCreAm";
        String res = reverseVowels(s);
        System.out.println(res);
    }

    private static String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');
        StringBuilder sb = new StringBuilder(s);
        int left =0;
        int n = s.length();
        int right = n-1;
        while(left<=right){
            char lCh = s.charAt(left);
            char rCh = s.charAt(right);
            if(vowels.contains(lCh) && vowels.contains(rCh)){
                sb.setCharAt(left, rCh);
                sb.setCharAt(right, lCh);
                left++;
                right--;
            }else if(vowels.contains(lCh)){
                right--;
            }else if(vowels.contains(rCh))left++;
            else{
                left++;
                right--;
            }

        }
        return sb.toString();
    }
}
