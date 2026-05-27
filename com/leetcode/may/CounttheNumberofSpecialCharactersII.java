package com.com.leetcode.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CounttheNumberofSpecialCharactersII {
    public static void main(String[] args) {
        String s = "abDBAbb";
        int count = countSpecialCharacters(s);
        System.out.println(count);
    }

    private static int countSpecialCharacters(String s) {
        int count = 0;
       int[] lowerCase = new int[26];
         int[] upperCase = new int[26];
         Arrays.fill(lowerCase, -1);
         Arrays.fill(upperCase, -1);
         for(int i=0;i<s.length();i++){
             char c = s.charAt(i);
             if(Character.isLowerCase(c)){
                 int idx = c-'a';
                 lowerCase[idx] = i;
             }else{
                    int idx = c-'A';
                    if(upperCase[idx] ==-1) upperCase[idx]=i;
             }
         }
            for(int i=0;i<26;i++){
                if(lowerCase[i] != -1 && upperCase[i] != -1){
                    if(lowerCase[i] < upperCase[i]) count++;
                }
            }
            return count;
    }
}
