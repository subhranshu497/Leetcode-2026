package com.com.leetcode.july;

import java.util.Map;

public class SmallestPalindromicRearrangementI {
    public static void main(String[] args) {
        String s = "daccad"; // abbbbaa
        String res = smallestPalindrome(s);
        System.out.println(res);
    }

    private static String smallestPalindrome(String s) {
        int n = s.length();
        char [] arr = new char[n];
        int [] freq = new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        //form the res
        int left =0;
        int right = n-1;
            for(int i=0;i<26;i++){
                while(freq[i]>=2){
                    //append the character to the left and right position of the stringbuilder
                    arr[left] = (char)(i+'a');
                    arr[right] = (char)(i+'a');
                    freq[i]-=2;
                    left++;
                    right--;
                }
            }
            //check for the mid char
            for(int i=0;i<26;i++){
                if(freq[i]==1){
                    arr[left] = (char)(i+'a');
                    break;
                }
            }
            //form the string from the char array
            return new String(arr);
    }
}
