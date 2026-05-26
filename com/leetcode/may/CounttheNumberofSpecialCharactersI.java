package com.com.leetcode.may;

import java.util.HashSet;
import java.util.Set;

public class CounttheNumberofSpecialCharactersI {
    public static void main(String[] args) {
        String s = "aaAbcBC";
        int count = countSpecial(s);
        System.out.println(count);
    }

    private static int countSpecial(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(char ch: s.toCharArray())set.add(ch);
        for(char ch: set){
            if(Character.isUpperCase(ch) && set.contains(Character.toLowerCase(ch)))count++;
        }
        return count;
    }
}
