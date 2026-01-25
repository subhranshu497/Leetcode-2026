package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagargm";
        System.out.println(isAnagram(s,t));
    }

    private static boolean isAnagram(String s, String t) {
        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return new String(sArr).equals(new String(tArr));
    }
}
